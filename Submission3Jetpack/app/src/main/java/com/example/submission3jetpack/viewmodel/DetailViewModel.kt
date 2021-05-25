package com.example.submission3jetpack.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.submission3jetpack.data.source.ContentRepository
import com.example.submission3jetpack.data.source.local.entity.MovieEntity
import com.example.submission3jetpack.data.source.local.entity.TvShowEntity
import com.example.submission3jetpack.vo.Resource

class DetailViewModel(private val mContentRepository: ContentRepository): ViewModel() {
    val movieId = MutableLiveData<String>()
    val tvShowId = MutableLiveData<String>()

    var detailMovie: LiveData<Resource<MovieEntity>> = Transformations.switchMap(movieId) { mMovieId ->
        mContentRepository.getDetailMovie(mMovieId)
    }

    var detailTvShow: LiveData<Resource<TvShowEntity>> = Transformations.switchMap(tvShowId) { mTvShowId ->
        mContentRepository.getDetailTvShow(mTvShowId)
    }

    fun setSelectMovie(movieId: String) {
        this.movieId.value = movieId
    }

    fun setSelectTvShow(tvShowId: String) {
        this.tvShowId.value = tvShowId
    }

    fun setFavoriteMovie() {
        val movieResource = detailMovie.value
        if (movieResource?.data != null) {
            val newState = !movieResource.data.isFavorite
            mContentRepository.setFavoriteMovie(movieResource.data, newState)
        }
    }

    fun setFavoriteTvShow() {
        val tvShowResource = detailTvShow.value
        if (tvShowResource?.data != null) {
            val newState = !tvShowResource.data.isFavorite
            mContentRepository.setFavoriteTvShow(tvShowResource.data, newState)
        }
    }
}