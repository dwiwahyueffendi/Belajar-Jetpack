package com.example.submission3jetpack.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.submission3jetpack.data.source.MovieAppRepository
import com.example.submission3jetpack.data.source.local.entity.MovieEntity
import com.example.submission3jetpack.vo.Resource

class DetailMovieViewModel(private val movieAppRepository: MovieAppRepository): ViewModel() {
    val movieId = MutableLiveData<String>()

    fun setSelectedMovie(movieId: String) {
        this.movieId.value = movieId
    }

    var detailMovie: LiveData<Resource<MovieEntity>> = Transformations.switchMap(movieId) { mMovieId ->
        movieAppRepository.getDetailMovie(mMovieId)
    }

    fun setFavoriteMovie() {
        val movieResource = detailMovie.value
        if (movieResource?.data != null) {
            val newState = !movieResource.data.isFavorite
            movieAppRepository.setFavoriteMovie(movieResource.data, newState)
        }
    }
}
