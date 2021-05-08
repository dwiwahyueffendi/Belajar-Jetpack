package com.example.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.ContentCatalogRepository
import com.example.myapplication.data.local.ContentEntity

class MovieViewModel(private val catalogRepository: ContentCatalogRepository) : ViewModel() {
    fun getListMovies(): LiveData<List<ContentEntity>> = catalogRepository.getPlayingMovies()
}