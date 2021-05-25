package com.example.submission3jetpack.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.submission3jetpack.data.source.ContentRepository
import com.example.submission3jetpack.data.source.local.entity.TvShowEntity
import com.example.submission3jetpack.vo.Resource

class TvShowViewModel(private val mContentRepository: ContentRepository): ViewModel() {
    fun getTvShows(): LiveData<Resource<PagedList<TvShowEntity>>> = mContentRepository.getTvShows()
}