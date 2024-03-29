package com.example.myapplication.view

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.example.myapplication.R
import com.example.myapplication.data.local.ContentEntity
import com.example.myapplication.databinding.ActivityDetailBinding
import com.example.myapplication.network.NetworkInfo
import com.example.myapplication.network.NetworkInfo.TYPE_MOVIE
import com.example.myapplication.network.NetworkInfo.TYPE_TV_SHOW
import com.example.myapplication.viewmodel.DetailViewModel
import com.example.myapplication.viewmodel.factory.ViewModelFactory

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var viewModel: DetailViewModel
    
    companion object {
        const val EXTRA_ID = "extra_id"
        const val EXTRA_CATEGORY = "extra_category"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = ViewModelFactory.getInstance()
        viewModel = ViewModelProvider(this@DetailActivity, factory)[DetailViewModel::class.java]

        binding.apply {
            setSupportActionBar(detailWidget)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            detailToolbar.setExpandedTitleColor(Color.TRANSPARENT)
        }

        val id = intent.getIntExtra(EXTRA_ID, 0)
        val category = intent.getStringExtra(EXTRA_CATEGORY)

        if (category.equals(TYPE_MOVIE, ignoreCase = true)) {
            val title = resources.getString(R.string.detail_movie)
            supportActionBar?.title = title

            viewModel.getMovieDetail(id).observe(this, Observer { movie ->
                setupUI(movie)
            })
        } else if (category.equals(TYPE_TV_SHOW, ignoreCase = true)) {
            val title = resources.getString(R.string.detail_tvShow)
            supportActionBar?.title = title

            viewModel.getTvShowDetail(id).observe(this, Observer {tvShow ->
                setupUI(tvShow)
            })
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    private fun setupUI(contentEntity: ContentEntity) {
        binding.apply {

            val requestOptions = RequestOptions()
            requestOptions.placeholder(R.drawable.ic_account)
            requestOptions.error(R.drawable.ic_error)

            tvDetailTitle.text = contentEntity.title
            tvDetailRelease.text = contentEntity.releaseDate
            tvDetailRating.text = contentEntity.voteAverage
            tvDetailDescription.text = contentEntity.desc

            Glide.with((this@DetailActivity))
                .load(NetworkInfo.IMAGE_URL + contentEntity.posterPath)
                .apply(RequestOptions()
                    .placeholder(R.drawable.ic_account)
                    .error(R.drawable.ic_error))
                .transition(DrawableTransitionOptions.withCrossFade())
                .centerCrop()
                .into(ivPosterPath)

            Glide.with((this@DetailActivity))
                .load(NetworkInfo.IMAGE_URL + contentEntity.backdropPath)
                .apply(RequestOptions()
                    .placeholder(R.drawable.ic_account)
                    .error(R.drawable.ic_error))
                .transition(DrawableTransitionOptions.withCrossFade())
                .centerCrop()
                .into(ivBackdropPath)
        }
    }
}