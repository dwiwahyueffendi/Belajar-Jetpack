package com.example.submission3jetpack.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.submission3jetpack.data.source.local.entity.MovieEntity
import com.example.submission3jetpack.data.source.local.entity.TvShowEntity
import com.example.submission3jetpack.vo.Resource

interface ContentDataSource {

    fun getMovies(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getDetailMovie(movieId: String): LiveData<Resource<MovieEntity>>

    fun setFavoriteMovie(movie: MovieEntity, state: Boolean)

    fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>>

    fun getTvShows(): LiveData<Resource<PagedList<TvShowEntity>>>

    fun getDetailTvShow(tvShowId: String): LiveData<Resource<TvShowEntity>>

    fun getFavoriteTvShows(): LiveData<PagedList<TvShowEntity>>

    fun setFavoriteTvShow(tvShow: TvShowEntity, state: Boolean)
}