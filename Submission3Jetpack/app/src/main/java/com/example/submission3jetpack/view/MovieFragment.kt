package com.example.submission3jetpack.view

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submission3jetpack.adapter.MovieAdapter
import com.example.submission3jetpack.data.source.local.entity.MovieEntity
import com.example.submission3jetpack.databinding.FragmentMovieBinding
import com.example.submission3jetpack.viewmodel.MovieViewModel
import com.example.submission3jetpack.viewmodel.factory.ViewModelFactory
import com.example.submission3jetpack.vo.Resource
import com.example.submission3jetpack.vo.Status

class MovieFragment : Fragment() {

    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding
    private lateinit var viewModel: MovieViewModel
    private lateinit var contentAdapter: MovieAdapter
    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

            contentAdapter = MovieAdapter()

            showInterface("LOADING")
            viewModel.getMovies().observe(viewLifecycleOwner, movieObserver)

            setupUserInterface()
        }
    }

    fun showInterface(key: String){
        if (key == "LOADING"){
            binding?.apply {
                progressBar.visibility = View.VISIBLE
            }
        } else if (key == "SUCCESS"){
            binding?.apply {
                progressBar.visibility = View.GONE
            }
        } else if (key == "ERROR"){
            binding?.apply {
                progressBar.visibility = View.GONE
                Toast.makeText(context, "ERROR", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupUserInterface() {
        binding?.let {
            with(it.rvMovies) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = contentAdapter
            }
        }

        contentAdapter.setOnItemClickCallback(object : MovieAdapter.OnItemClickCallback {
            override fun onItemClicked(movieId: String) {
                val intent = Intent(context, DetailMovieActivity::class.java).apply {
                    putExtra(DetailMovieActivity.EXTRA_MOVIE, movieId)
                }
                startActivity(intent)
            }
        })
    }

    private val movieObserver = Observer<Resource<PagedList<MovieEntity>>> { listMovies ->
        if (listMovies != null) {
            when (listMovies.status) {
                Status.LOADING -> showInterface("LOADING")
                Status.SUCCESS -> {
                    showInterface("SUCCES")
                    contentAdapter.submitList(listMovies.data)
                }
                Status.ERROR -> {
                    showInterface("ERROR")
                    Toast.makeText(context, "ERROR", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}