package com.example.submission3jetpack.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.submission3jetpack.data.source.ContentRepository
import com.example.submission3jetpack.data.source.local.entity.MovieEntity
import com.example.submission3jetpack.vo.Resource

class MovieViewModel(private val mContentRepository: ContentRepository): ViewModel() {
    fun getMovies(): LiveData<Resource<PagedList<MovieEntity>>> = mContentRepository.getMovies()
}