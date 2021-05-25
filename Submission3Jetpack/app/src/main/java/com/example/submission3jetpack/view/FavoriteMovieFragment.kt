package com.example.submission3jetpack.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.submission3jetpack.R
import com.example.submission3jetpack.adapter.FavoriteMovieAdapter
import com.example.submission3jetpack.databinding.FragmentFavoriteMovieBinding
import com.google.android.material.snackbar.Snackbar
import com.example.submission3jetpack.viewmodel.FavoriteViewModel
import com.example.submission3jetpack.viewmodel.factory.ViewModelFactory

class FavoriteMovieFragment : Fragment() {

    private var _binding: FragmentFavoriteMovieBinding? = null
    private val binding get() = _binding

    private lateinit var viewModel: FavoriteViewModel
    private lateinit var favoriteMovieAdapter: FavoriteMovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =
            FragmentFavoriteMovieBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(binding?.rvFavoriteMovies)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]

            favoriteMovieAdapter = FavoriteMovieAdapter()

            showLoading(true)
            viewModel.getFavoriteMovies().observe(viewLifecycleOwner, { favoriteMovies ->
                showLoading(false)
                favoriteMovieAdapter.submitList(favoriteMovies)
            })

            showRecyclerView()
        }
    }

    private fun showRecyclerView() {
        binding?.let {
            with(it.rvFavoriteMovies) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = favoriteMovieAdapter
            }
        }

        favoriteMovieAdapter.setOnItemClickCallback(object :
            FavoriteMovieAdapter.OnItemClickCallback {
            override fun onItemClicked(movieId: String) {
                val intent = Intent(context, DetailMovieActivity::class.java).apply {
                    putExtra(DetailMovieActivity.EXTRA_MOVIE, movieId)
                }
                startActivity(intent)
            }
        })
    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder
        ): Int = makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.adapterPosition
                val movieEntity = favoriteMovieAdapter.getSwiped(swipedPosition)
                movieEntity?.let { viewModel.setFavoriteMovie(it) }

                val snackbar = Snackbar.make(view as View, R.string.undo_movie, Snackbar.LENGTH_LONG)
                snackbar.setAction(R.string.undo) { _ ->
                    movieEntity?.let { viewModel.setFavoriteMovie(it) }
                }
                snackbar.show()
            }
        }
    })

    private fun showLoading(state: Boolean) {
        if (state) {
            binding?.apply {
                progressBar.visibility = View.VISIBLE
            }
        } else {
            binding?.apply {
                progressBar.visibility = View.GONE
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}