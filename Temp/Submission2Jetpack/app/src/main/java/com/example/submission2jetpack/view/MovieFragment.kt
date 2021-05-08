package com.example.submission2jetpack.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submission2jetpack.adapter.MovieAdapter
import com.example.submission2jetpack.databinding.FragmentMovieBinding
import com.example.submission2jetpack.viewmodel.DetailViewModel.Companion.MOVIE
import com.example.submission2jetpack.viewmodel.MainViewModel
import com.example.submission2jetpack.viewmodel.ViewModelFactory

class MovieFragment : Fragment(), MovieAdapter.OnItemClickCallback {

    private lateinit var binding: FragmentMovieBinding
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showProgressBar(true)

        val factory = ViewModelFactory.getInstance(requireActivity())
        val viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]

        viewModel.getListMovie().observe(viewLifecycleOwner, { movie ->
            showProgressBar(false)
            movieAdapter.setMovies(movie)
            movieAdapter.setOnItemClickCallback(this)
            movieAdapter.notifyDataSetChanged()
        })

        with(binding.rvMovie) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            this.adapter = movieAdapter
        }
    }

    override fun onItemClicked(id: Int) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_FILM, id)
        intent.putExtra(DetailActivity.EXTRA_CATEGORY, MOVIE)

        context?.startActivity(intent)
    }

    private fun showProgressBar(state: Boolean) {
        binding.progressBar.isVisible = state
        binding.rvMovie.isInvisible = state
    }
}