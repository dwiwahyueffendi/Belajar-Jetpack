package com.example.myapplication.data

import androidx.lifecycle.LiveData
import com.example.myapplication.data.local.ContentEntity

interface ContentCatalogDataSource {
    fun getPlayingMovies(): LiveData<List<ContentEntity>>
    fun getMovieDetail(movieId: Int): LiveData<ContentEntity>
    fun getPlayingTvShow(): LiveData<List<ContentEntity>>
    fun getTvShowDetail(tvShowId: Int): LiveData<ContentEntity>
}