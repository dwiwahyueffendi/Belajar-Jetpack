package com.example.submission3jetpack.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.submission3jetpack.data.source.MovieAppRepository
import com.example.submission3jetpack.data.source.local.entity.TvShowEntity
import com.example.submission3jetpack.vo.Resource

class DetailTvShowViewModel(private val movieAppRepository: MovieAppRepository): ViewModel() {
    val tvShowId = MutableLiveData<String>()

    fun setSelectedTvShow(tvShowId: String) {
        this.tvShowId.value = tvShowId
    }

    var detailTvShow: LiveData<Resource<TvShowEntity>> = Transformations.switchMap(tvShowId) { mTvShowId ->
        movieAppRepository.getDetailTvShow(mTvShowId)
    }

    fun setFavoriteTvShow() {
        val tvShowResource = detailTvShow.value
        if (tvShowResource?.data != null) {
            val newState = !tvShowResource.data.isFavorite
            movieAppRepository.setFavoriteTvShow(tvShowResource.data, newState)
        }
    }
}
