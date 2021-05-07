package com.example.submission2jetpack.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.submission2jetpack.data.local.DetailEntity
import com.example.submission2jetpack.databinding.ActivityDetailBinding
import com.example.submission2jetpack.network.NetworkInfo.IMAGE_URL
import com.example.submission2jetpack.viewmodel.DetailViewModel
import com.example.submission2jetpack.viewmodel.ViewModelFactory

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val EXTRA_FILM = "extra_film"
        const val EXTRA_CATEGORY = "extra_category"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        setupToolbar()

        val extras = intent.extras
        if (extras != null) {
            val dataId = extras.getString(EXTRA_FILM)
            val dataCategory = extras.getString(EXTRA_CATEGORY)

            if (dataId != null && dataCategory != null) {
                viewModel.setContent(dataId, dataCategory)
                viewModel.getContent().observe(this){ detail ->
                    populateDataDetail(detail)
                }
            }
        }
    }

    private fun setupToolbar() {
        binding.apply {
            setSupportActionBar(detailToolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            collapToolbar.setExpandedTitleColor(Color.TRANSPARENT)
        }

    }

    private fun populateDataDetail(data: DetailEntity) {
        binding.apply {
            tvDetailTitle.text = data.title
            tvDetailRelease.text = data.releaseDate
            tvDetailRating.text = data.voteAverage.toString()
            tvDescription.text = data.desc
        }

        Glide.with(this@DetailActivity)
            .load(IMAGE_URL + data.backdropPath)
            .transition(DrawableTransitionOptions.withCrossFade())
            .centerCrop()
            .into(binding.ivDetailHighlight)

        Glide.with(this@DetailActivity)
            .load(IMAGE_URL + data.posterPath)
            .transition(DrawableTransitionOptions.withCrossFade())
            .centerCrop()
            .into(binding.ivPoster)

        binding.apply {
            ivDetailHighlight.tag = data.backdropPath
            ivPoster.tag = data.posterPath
        }
    }
}