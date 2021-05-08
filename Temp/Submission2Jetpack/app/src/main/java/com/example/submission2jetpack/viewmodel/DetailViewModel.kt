package com.example.submission2jetpack.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.submission2jetpack.data.ContentRepository
import com.example.submission2jetpack.data.local.DetailEntity

class DetailViewModel(private val mContentRepository: ContentRepository): ViewModel() {

    private lateinit var detailContent: LiveData<DetailEntity>

    companion object {
        const val MOVIE = "movie"
        const val TV_SHOW = "tvShow"
    }

    fun setContent(id: String, category: String) {
        when (category) {
            MOVIE -> {
                detailContent = mContentRepository.getDetailMovie(id)
            }
            TV_SHOW -> {
                detailContent = mContentRepository.getDetailTvShow(id)
            }
        }
    }

    fun getContent() = detailContent
}