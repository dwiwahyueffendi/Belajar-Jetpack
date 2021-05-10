package com.example.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.ContentCatalogRepository
import com.example.myapplication.data.local.ContentEntity

class DetailViewModel(private val catalogRepository: ContentCatalogRepository) : ViewModel() {
    fun getMovieDetail(movieId: Int): LiveData<ContentEntity> = catalogRepository.getMovieDetail(movieId)
    fun getTvShowDetail(tvShowId: Int): LiveData<ContentEntity> = catalogRepository.getTvShowDetail(tvShowId)
}