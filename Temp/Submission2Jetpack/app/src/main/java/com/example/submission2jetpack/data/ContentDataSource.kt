package com.example.submission2jetpack.data

import androidx.lifecycle.LiveData
import com.example.submission2jetpack.data.local.DetailEntity
import com.example.submission2jetpack.data.local.MovieEntity
import com.example.submission2jetpack.data.local.TvShowEntity

interface ContentDataSource {

    fun getMovie(): LiveData<List<MovieEntity>>

    fun getDetailMovie(idMovie: String): LiveData<DetailEntity>

    fun getTvShow(): LiveData<List<TvShowEntity>>

    fun getDetailTvShow(idTvShow: String): LiveData<DetailEntity>
}