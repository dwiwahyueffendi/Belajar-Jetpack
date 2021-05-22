package com.example.submission3jetpack.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.example.submission3jetpack.data.source.local.entity.TvShowEntity
import com.example.submission3jetpack.data.source.local.room.MovieAppDao
import com.example.submission3jetpack.data.source.local.entity.MovieEntity
import com.example.submission3jetpack.utils.SortUtils
import com.example.submission3jetpack.utils.SortUtils.MOVIE_ENTITIES
import com.example.submission3jetpack.utils.SortUtils.TV_SHOW_ENTITIES

class LocalDataSource(private val mMovieAppDao: MovieAppDao) {

    companion object {
         private var INSTANCE: LocalDataSource? = null

         fun getInstance(movieAppDao: MovieAppDao): LocalDataSource {
             if (INSTANCE == null) {
                 INSTANCE = LocalDataSource(movieAppDao)
             }
             return INSTANCE as LocalDataSource
         }
     }

    fun getMovies(sort: String): DataSource.Factory<Int, MovieEntity> =
        mMovieAppDao.getMovies(SortUtils.getSortedQuery(sort, MOVIE_ENTITIES))

    fun getFavoriteMovies(): DataSource.Factory<Int, MovieEntity> = mMovieAppDao.getFavoriteMovies()

    fun getDetailMovieById(id: String): LiveData<MovieEntity> = mMovieAppDao.getDetailMovieById(id)

    fun getTvShows(sort: String): DataSource.Factory<Int, TvShowEntity> =
        mMovieAppDao.getTvShows(SortUtils.getSortedQuery(sort, TV_SHOW_ENTITIES))

    fun getFavoriteTvShows(): DataSource.Factory<Int, TvShowEntity> = mMovieAppDao.getFavoriteTvShows()

    fun getDetailTvShowById(id: String): LiveData<TvShowEntity> = mMovieAppDao.getDetailTvShowById(id)

    fun insertMovies(movies: List<MovieEntity>) = mMovieAppDao.insertMovies(movies)

    fun setFavoriteMovie(movie: MovieEntity, newState: Boolean) {
        movie.isFavorite = newState
        mMovieAppDao.updateMovie(movie)
    }

    fun updateMovie(movie: MovieEntity, newState: Boolean) {
        movie.isFavorite = newState
        mMovieAppDao.updateMovie(movie)
    }

    fun insertTvShows(tvShows: List<TvShowEntity>) = mMovieAppDao.insertTvShows(tvShows)

    fun setFavoriteTvShow(tvShow: TvShowEntity, newState: Boolean) {
        tvShow.isFavorite = newState
        mMovieAppDao.updateTvShow(tvShow)
    }

    fun updateTvShow(tvShow: TvShowEntity, newState: Boolean) {
        tvShow.isFavorite = newState
        mMovieAppDao.updateTvShow(tvShow)
    }
}