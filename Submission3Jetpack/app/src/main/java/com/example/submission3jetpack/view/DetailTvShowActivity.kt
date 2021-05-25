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
import com.example.submission3jetpack.data.source.local.entity.TvShowEntity
import com.example.submission3jetpack.databinding.ActivityDetailTvshowBinding
import com.example.submission3jetpack.network.NetworkInfo.IMAGE_URL
import com.example.submission3jetpack.viewmodel.DetailViewModel
import com.example.submission3jetpack.viewmodel.factory.ViewModelFactory
import com.example.submission3jetpack.vo.Status

class DetailTvShowActivity : AppCompatActivity() {

    private var _binding: ActivityDetailTvshowBinding? = null
    private val detailTvShowBinding get() = _binding
    private lateinit var viewModel: DetailViewModel
    private val contentDetailTvShowBinding get() = _binding?.detailTvshow
    private var menu: Menu? = null

    companion object {
        const val EXTRA_TV_SHOW = "extra_tv_show"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding =  ActivityDetailTvshowBinding.inflate(layoutInflater)
        setContentView(detailTvShowBinding?.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.elevation = 0f

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val tvShowId = extras.getString(EXTRA_TV_SHOW)
            if (tvShowId != null) {
                viewModel.setSelectTvShow(tvShowId)
                viewModel.detailTvShow.observe(this, { tvShow ->
                    when (tvShow.status) {
                        Status.LOADING -> showInterface("LOADING")
                        Status.SUCCESS -> if (tvShow.data != null) {
                            showInterface("SUCCES")
                            showData(tvShow.data)
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
            detailTvShowBinding?.apply {
                progressBar.visibility = View.VISIBLE
                nestedTvshow.visibility = View.INVISIBLE
            }
        } else if (key == "SUCCESS"){
            detailTvShowBinding?.apply {
                progressBar.visibility = View.GONE
                nestedTvshow.visibility = View.VISIBLE
            }
        } else if (key == "ERROR"){
            detailTvShowBinding?.apply {
                progressBar.visibility = View.INVISIBLE
                nestedTvshow.visibility = View.INVISIBLE
                Toast.makeText(applicationContext, "ERROR", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showData(tvShow: TvShowEntity) {
        with(contentDetailTvShowBinding){
            val requestOptions = RequestOptions()
            requestOptions.placeholder(R.drawable.ic_loading)
            requestOptions.error(R.drawable.ic_error)

            this?.ivPoster?.let {
                Glide.with(this@DetailTvShowActivity)
                    .load(IMAGE_URL + tvShow.posterPath)
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
                Glide.with(this@DetailTvShowActivity)
                    .load(IMAGE_URL + tvShow.backdropPath)
                    .apply(
                        RequestOptions()
                            .placeholder(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .centerCrop()
                    .into(it)
            }

            this?.tvTitle?.text = tvShow.name
            this?.tvTitle?.isSelected = true
            this?.tvTitle?.isSingleLine = true
            this?.tvDescription?.text = tvShow.overview
            this?.tvRelease?.text = tvShow.firstAirDate
            this?.tvRating?.text = tvShow.voteAverage.toString()
            
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_favorite, menu)
        this.menu = menu
        viewModel.detailTvShow.observe(this, { tvShow ->
            if (tvShow != null) {
                when (tvShow.status) {
                    Status.LOADING -> showInterface("LOADING")
                    Status.SUCCESS -> if (tvShow.data != null) {
                        showInterface("SUCCESS")
                        val state = tvShow.data.isFavorite
                        setFavoriteState(state)
                    }
                    Status.ERROR -> showInterface("ERROR")
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
}