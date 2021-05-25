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
import com.google.android.material.snackbar.Snackbar
import com.example.submission3jetpack.adapter.FavoriteTvShowAdapter
import com.example.submission3jetpack.databinding.FragmentFavoriteTvShowBinding
import com.example.submission3jetpack.viewmodel.FavoriteViewModel
import com.example.submission3jetpack.viewmodel.factory.ViewModelFactory

class FavoriteTvShowFragment : Fragment() {

    private var _binding: FragmentFavoriteTvShowBinding? = null
    private val binding get() = _binding

    private lateinit var viewModel: FavoriteViewModel
    private lateinit var favoriteTvShowAdapter: FavoriteTvShowAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentFavoriteTvShowBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(binding?.rvFavoriteTvShows)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]

            favoriteTvShowAdapter = FavoriteTvShowAdapter()

            showLoading(true)
            viewModel.getFavoriteTvShows().observe(viewLifecycleOwner, { favoriteTvShows ->
                showLoading(false)
                favoriteTvShowAdapter.submitList(favoriteTvShows)
            })

            binding?.let {
                with(it.rvFavoriteTvShows) {
                    layoutManager = LinearLayoutManager(context)
                    setHasFixedSize(true)
                    adapter = favoriteTvShowAdapter
                }
            }

            favoriteTvShowAdapter.setOnItemClickCallback(object :
                FavoriteTvShowAdapter.OnItemClickCallback {
                override fun onItemClicked(tvShowId: String) {
                    val intent = Intent(context, DetailTvShowActivity::class.java).apply {
                        putExtra(DetailTvShowActivity.EXTRA_TV_SHOW, tvShowId)
                    }
                    startActivity(intent)
                }
            })
        }
    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int = makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)

        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.adapterPosition
                val tvShowEntity = favoriteTvShowAdapter.getSwiped(swipedPosition)
                tvShowEntity?.let { viewModel.setFavoriteTvShow(it) }

                val snackbar = Snackbar.make(view as View, R.string.undo_tvshow, Snackbar.LENGTH_LONG)
                snackbar.setAction(R.string.undo) { _ ->
                    tvShowEntity?.let { viewModel.setFavoriteTvShow(it) }
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