package com.example.submission2jetpack.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.submission2jetpack.data.ContentRepository
import com.example.submission2jetpack.data.local.MovieEntity
import com.example.submission2jetpack.data.local.TvShowEntity

class MainViewModel(private val mContentRepository: ContentRepository): ViewModel() {

    fun getListMovie(): LiveData<List<MovieEntity>>{
        return mContentRepository.getMovie()
    }

    fun getListTvShow(): LiveData<List<TvShowEntity>>{
        return mContentRepository.getTvShow()
    }
}