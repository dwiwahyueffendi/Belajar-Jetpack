package com.example.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.ContentCatalogRepository
import com.example.myapplication.data.local.ContentEntity

class TvShowViewModel(private val catalogRepository: ContentCatalogRepository) : ViewModel() {
    fun getListTvShow(): LiveData<List<ContentEntity>> = catalogRepository.getPlayingTvShow()
}