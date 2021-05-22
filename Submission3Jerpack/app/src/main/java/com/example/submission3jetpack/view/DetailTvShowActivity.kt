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
import com.example.submission3jetpack.data.source.local.entity.TvShowEntity
import com.example.submission3jetpack.databinding.ActivityDetailTvShowBinding
import com.example.submission3jetpack.network.NetworkInfo.IMAGE_URL
import com.example.submission3jetpack.utils.Convert
import com.example.submission3jetpack.viewmodel.DetailTvShowViewModel
import com.example.submission3jetpack.viewmodel.factory.ViewModelFactory
import com.example.submission3jetpack.vo.Status
import com.squareup.picasso.Picasso

class DetailTvShowActivity : AppCompatActivity() {

    private var _activityDetailTvShowBinding: ActivityDetailTvShowBinding? = null
    private val detailTvShowBinding get() = _activityDetailTvShowBinding
    private val contentDetailTvShowBinding get() = _activityDetailTvShowBinding?.detailTvShow
    private lateinit var viewModel: DetailTvShowViewModel
    private var menu: Menu? = null

    companion object {
        const val EXTRA_TV_SHOW = "extra_tv_show"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _activityDetailTvShowBinding =  ActivityDetailTvShowBinding.inflate(layoutInflater)
        setContentView(detailTvShowBinding?.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.elevation = 0f

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailTvShowViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val tvShowId = extras.getString(EXTRA_TV_SHOW)
            if (tvShowId != null) {
                detailTvShowBinding?.progressBar?.visibility = View.VISIBLE
                detailTvShowBinding?.contentTvShow?.visibility = View.INVISIBLE
                viewModel.setSelectedTvShow(tvShowId)
                viewModel.detailTvShow.observe(this, { tvShow ->
                    when (tvShow.status) {
                        Status.LOADING -> {
                            detailTvShowBinding?.progressBar?.visibility = View.VISIBLE
                            detailTvShowBinding?.contentTvShow?.visibility = View.INVISIBLE
                        }
                        Status.SUCCESS -> if (tvShow.data != null) {
                            detailTvShowBinding?.progressBar?.visibility = View.GONE
                            detailTvShowBinding?.contentTvShow?.visibility = View.VISIBLE
                            populateTvShow(tvShow.data)
                        }
                        Status.ERROR -> {
                            detailTvShowBinding?.progressBar?.visibility = View.INVISIBLE
                            detailTvShowBinding?.contentTvShow?.visibility = View.INVISIBLE
                            Toast.makeText(applicationContext, "Failed to Load Data", Toast.LENGTH_SHORT).show()
                        }
                    }
                })
            }
        }
    }

    private fun populateTvShow(tvShow: TvShowEntity) {
        with(contentDetailTvShowBinding){
            this?.tvName?.text = tvShow.name
            this?.tvName?.isSelected = true
            this?.tvName?.isSingleLine = true
            this?.tvDescription?.text = tvShow.overview
            this?.tvGenre?.text = tvShow.genres
            this?.tvGenre?.isSelected = true
            this?.tvGenre?.isSingleLine = true
            this?.tvRelease?.text = tvShow.firstAirDate?.let { Convert.convertStringToDate(it) }
            this?.tvRating?.text = tvShow.voteAverage.toString()
            if (tvShow.tagline.isNullOrEmpty()) {
                this?.tvTaglineTitle?.visibility = View.GONE
            }
            this?.tvQuoteValue?.text = tvShow.tagline

            Picasso.get()
                .load("${IMAGE_URL}w185${tvShow.posterPath}")
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_error)
                .into(this?.imagePoster)

            Picasso.get()
                .load("${IMAGE_URL}w500${tvShow.backdropPath}")
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_error)
                .into(this?.imageBackdrop)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_favorite, menu)
        this.menu = menu
        viewModel.detailTvShow.observe(this, { tvShow ->
            if (tvShow != null) {
                when (tvShow.status) {
                    Status.LOADING -> {
                        detailTvShowBinding?.progressBar?.visibility = View.VISIBLE
                        detailTvShowBinding?.contentTvShow?.visibility = View.INVISIBLE
                    }
                    Status.SUCCESS -> if (tvShow.data != null) {
                        detailTvShowBinding?.progressBar?.visibility = View.GONE
                        detailTvShowBinding?.contentTvShow?.visibility = View.VISIBLE
                        val state = tvShow.data.isFavorite
                        setFavoriteState(state)
                    }
                    Status.ERROR -> {
                        detailTvShowBinding?.progressBar?.visibility = View.INVISIBLE
                        detailTvShowBinding?.contentTvShow?.visibility = View.INVISIBLE
                        Toast.makeText(applicationContext, "Failed to Load Data", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.favorite) {
            viewModel.setFavoriteTvShow()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setFavoriteState(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.favorite)
        if (state) {
            menuItem?.icon =  ContextCompat.getDrawable(this, R.drawable.ic_favorite)
        } else {
            menuItem?.icon =  ContextCompat.getDrawable(this, R.drawable.ic_unfavorite)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        super.onBackPressed()
        return true
    }
}