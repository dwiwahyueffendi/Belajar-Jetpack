package com.example.submission3jetpack.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.submission3jetpack.data.source.local.entity.MovieEntity
import com.example.submission3jetpack.data.source.local.entity.TvShowEntity
import com.example.submission3jetpack.vo.Resource

interface MovieAppDataSource {

    fun getMovies(sort: String): LiveData<Resource<PagedList<MovieEntity>>>

    fun getTvShows(sort: String): LiveData<Resource<PagedList<TvShowEntity>>>

    fun getDetailMovie(movieId: String): LiveData<Resource<MovieEntity>>

    fun getDetailTvShow(tvShowId: String): LiveData<Resource<TvShowEntity>>

    fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>>

    fun getFavoriteTvShows(): LiveData<PagedList<TvShowEntity>>

    fun setFavoriteMovie(movie: MovieEntity, state: Boolean)

    fun setFavoriteTvShow(tvShow: TvShowEntity, state: Boolean)
}