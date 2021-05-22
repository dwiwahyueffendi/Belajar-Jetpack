package com.example.submission3jetpack.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.submission3jetpack.data.source.MovieAppRepository
import com.example.submission3jetpack.data.source.local.entity.MovieEntity

class FavoriteMovieViewModel(private val movieAppRepository: MovieAppRepository): ViewModel() {

    fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>> = movieAppRepository.getFavoriteMovies()

    fun setFavoriteMovie(movieEntity: MovieEntity) {
        val newState = !movieEntity.isFavorite
        movieAppRepository.setFavoriteMovie(movieEntity, newState)
    }
}