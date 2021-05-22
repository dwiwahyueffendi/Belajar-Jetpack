package com.example.submission3jetpack.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.submission3jetpack.data.source.MovieAppRepository
import com.example.submission3jetpack.data.source.local.entity.TvShowEntity
import com.example.submission3jetpack.vo.Resource

class TvShowViewModel(private val movieAppRepository: MovieAppRepository): ViewModel() {

    fun getTvShows(sort: String): LiveData<Resource<PagedList<TvShowEntity>>> =
            movieAppRepository.getTvShows(sort)
}