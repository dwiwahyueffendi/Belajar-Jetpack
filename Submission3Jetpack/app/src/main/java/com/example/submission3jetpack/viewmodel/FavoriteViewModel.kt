package com.example.submission3jetpack.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.submission3jetpack.data.source.ContentRepository
import com.example.submission3jetpack.data.source.local.entity.MovieEntity
import com.example.submission3jetpack.data.source.local.entity.TvShowEntity

class FavoriteViewModel(private val mContentRepository: ContentRepository): ViewModel() {

    fun setFavoriteMovie(movieEntity: MovieEntity) {
        val newState = !movieEntity.isFavorite
        mContentRepository.setFavoriteMovie(movieEntity, newState)
    }

    fun setFavoriteTvShow(tvShowEntity: TvShowEntity) {
        val newState = !tvShowEntity.isFavorite
        mContentRepository.setFavoriteTvShow(tvShowEntity, newState)
    }

    fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>> = mContentRepository.getFavoriteMovies()

    fun getFavoriteTvShows(): LiveData<PagedList<TvShowEntity>> = mContentRepository.getFavoriteTvShows()
}