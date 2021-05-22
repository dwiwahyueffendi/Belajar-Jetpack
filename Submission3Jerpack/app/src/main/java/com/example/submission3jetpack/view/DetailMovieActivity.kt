package com.example.submission3jetpack.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.submission3jetpack.R
import com.example.submission3jetpack.data.source.local.entity.MovieEntity
import com.example.submission3jetpack.databinding.ActivityDetailMovieBinding
import com.example.submission3jetpack.network.NetworkInfo.IMAGE_URL
import com.example.submission3jetpack.utils.Convert
import com.example.submission3jetpack.viewmodel.factory.ViewModelFactory
import com.example.submission3jetpack.vo.Status
import com.example.submission3jetpack.viewmodel.DetailMovieViewModel
import com.squareup.picasso.Picasso

class DetailMovieActivity : AppCompatActivity() {

    private var _activityDetailMovieBinding: ActivityDetailMovieBinding? = null
    private val detailMovieBinding get() = _activityDetailMovieBinding
    private val contentDetailMovieBinding get() = _activityDetailMovieBinding?.detailMovie
    private lateinit var viewModel: DetailMovieViewModel
    private var menu: Menu? = null

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(detailMovieBinding?.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.elevation = 0f

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailMovieViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            if (movieId != null) {
                viewModel.setSelectedMovie(movieId)
                viewModel.detailMovie.observe(this, { movie ->
                    when (movie.status) {
                        Status.LOADING -> {
                            detailMovieBinding?.progressBar?.visibility = View.VISIBLE
                            detailMovieBinding?.contentMovie?.visibility = View.INVISIBLE
                        }
                        Status.SUCCESS -> if (movie.data != null) {
                            detailMovieBinding?.progressBar?.visibility = View.GONE
                            detailMovieBinding?.contentMovie?.visibility = View.VISIBLE
                            populateMovie(movie.data)
                        }
                        Status.ERROR -> {
                            detailMovieBinding?.progressBar?.visibility = View.INVISIBLE
                            detailMovieBinding?.contentMovie?.visibility = View.INVISIBLE
                            Toast.makeText(
                                applicationContext,
                                "Failed to Load Data",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                })
            }
        }
    }

    private fun populateMovie(movie: MovieEntity) {
        with(contentDetailMovieBinding) {
            this?.tvTitle?.text = movie.title
            this?.tvTitle?.isSelected = true
            this?.tvTitle?.isSingleLine = true
            this?.tvDescription?.text = movie.overview
            this?.tvGenre?.text = movie.genres
            this?.tvGenre?.isSelected = true
            this?.tvGenre?.isSingleLine = true
            this?.tvRelease?.text = movie.releaseDate?.let { Convert.convertStringToDate(it) }
            this?.tvRating?.text = movie.voteAverage.toString()
            this?.tvDuration?.text = movie.runtime?.let { Convert.runtimeToHours(it) }
            if (movie.tagline.isNullOrEmpty()) {
                this?.tvTaglineTitle?.visibility = View.GONE
            }
            this?.tvQuoteValue?.text = movie.tagline

            Picasso.get()
                .load("${IMAGE_URL}w185${movie.posterPath}")
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_error)
                .into(this?.imagePoster)

            Picasso.get()
                .load("${IMAGE_URL}w500${movie.backdropPath}")
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_error)
                .into(this?.imageBackdrop)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_favorite, menu)
        this.menu = menu
        viewModel.detailMovie.observe(this, { movie ->
            if (movie != null) {
                when (movie.status) {
                    Status.LOADING -> {
                        detailMovieBinding?.progressBar?.visibility = View.VISIBLE
                        detailMovieBinding?.contentMovie?.visibility = View.INVISIBLE
                    }
                    Status.SUCCESS -> if (movie.data != null) {
                        detailMovieBinding?.progressBar?.visibility = View.GONE
                        detailMovieBinding?.contentMovie?.visibility = View.VISIBLE
                        val state = movie.data.isFavorite
                        setFavoriteState(state)
                    }
                    Status.ERROR -> {
                        detailMovieBinding?.progressBar?.visibility = View.INVISIBLE
                        detailMovieBinding?.contentMovie?.visibility = View.INVISIBLE
                        Toast.makeText(
                            applicationContext,
                            "Failed to Load Data",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        })
        return true
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

    override fun onSupportNavigateUp(): Boolean {
        super.onBackPressed()
        return true
    }
}