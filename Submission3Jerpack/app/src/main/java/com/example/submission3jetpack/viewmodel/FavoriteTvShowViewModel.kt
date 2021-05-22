package com.example.submission3jetpack.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.submission3jetpack.data.source.MovieAppRepository
import com.example.submission3jetpack.data.source.local.entity.TvShowEntity
class FavoriteTvShowViewModel(private val movieAppRepository: MovieAppRepository): ViewModel() {

    fun getFavoriteTvShows(): LiveData<PagedList<TvShowEntity>> = movieAppRepository.getFavoriteTvShows()

    fun setFavoriteTvShow(tvShowEntity: TvShowEntity) {
        val newState = !tvShowEntity.isFavorite
        movieAppRepository.setFavoriteTvShow(tvShowEntity, newState)
    }
}