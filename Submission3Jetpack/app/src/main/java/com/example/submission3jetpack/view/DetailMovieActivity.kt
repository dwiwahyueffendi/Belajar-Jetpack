package com.example.submission3jetpack.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.example.submission3jetpack.R
import com.example.submission3jetpack.data.source.local.entity.MovieEntity
import com.example.submission3jetpack.databinding.ActivityDetailMovieBinding
import com.example.submission3jetpack.network.NetworkInfo.IMAGE_URL
import com.example.submission3jetpack.viewmodel.factory.ViewModelFactory
import com.example.submission3jetpack.vo.Status
import com.example.submission3jetpack.viewmodel.DetailViewModel

class DetailMovieActivity : AppCompatActivity() {

    private var _binding: ActivityDetailMovieBinding? = null
    private val detailMovieBinding get() = _binding
    private lateinit var viewModel: DetailViewModel
    private val contentDetailMovieBinding get() = _binding?.detailMovie
    private var menu: Menu? = null

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(detailMovieBinding?.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.elevation = 0f

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            if (movieId != null) {
                viewModel.setSelectMovie(movieId)
                viewModel.detailMovie.observe(this, { movie ->
                    when (movie.status) {
                        Status.LOADING -> {
                            showInterface("LOADING")
                        }
                        Status.SUCCESS -> if (movie.data != null) {
                            showInterface("SUCCES")
                            showData(movie.data)
                        }
                        Status.ERROR -> {
                            showInterface("ERROR")
                        }
                    }

                })
            }
        }
    }

    fun showInterface(key: String){
        if (key == "LOADING"){
            detailMovieBinding?.apply {
                progressBar.visibility = View.VISIBLE
                nestedMovie.visibility = View.INVISIBLE
            }
        } else if (key == "SUCCESS"){
            detailMovieBinding?.apply {
                progressBar.visibility = View.GONE
                nestedMovie.visibility = View.VISIBLE
            }
        } else if (key == "ERROR"){
            detailMovieBinding?.apply {
                progressBar.visibility = View.INVISIBLE
                nestedMovie.visibility = View.INVISIBLE
                Toast.makeText(applicationContext, "Failed to Load Data", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showData(movie: MovieEntity) {
        with(contentDetailMovieBinding) {
            val requestOptions = RequestOptions()
            requestOptions.placeholder(R.drawable.ic_loading)
            requestOptions.error(R.drawable.ic_error)

            this?.ivPoster?.let {
                Glide.with(this@DetailMovieActivity)
                    .load(IMAGE_URL + movie.posterPath)
                    .apply(
                        RequestOptions()
                            .placeholder(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .centerCrop()
                    .into(it)
            }

            this?.ivBackdropDetail?.let {
                Glide.with(this@DetailMovieActivity)
                    .load(IMAGE_URL + movie.backdropPath)
                    .apply(
                        RequestOptions()
                            .placeholder(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .centerCrop()
                    .into(it)
            }

            this?.tvTitle?.text = movie.title
            this?.tvTitle?.isSelected = true
            this?.tvTitle?.isSingleLine = true
            this?.tvDescription?.text = movie.overview
            this?.tvRelease?.text = movie.releaseDate
            this?.tvRating?.text = movie.voteAverage.toString()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_favorite, menu)
        this.menu = menu
        viewModel.detailMovie.observe(this, { movie ->
            if (movie != null) {
                when (movie.status) {
                    Status.LOADING -> showInterface("LOADING")
                    Status.SUCCESS -> if (movie.data != null) {
                        showInterface("SUCCESS")
                        val state = movie.data.isFavorite
                        setFavoriteState(state)
                    }
                    Status.ERROR -> showInterface("ERROR")
                }
            }
        })
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.favorite) {
            viewModel.setFavoriteMovie()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setFavoriteState(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.favorite)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_unfavorite)
        }
    }
}