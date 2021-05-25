package com.example.submission3jetpack.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.example.submission3jetpack.data.source.local.entity.TvShowEntity
import com.example.submission3jetpack.data.source.local.room.MovieDao
import com.example.submission3jetpack.data.source.local.entity.MovieEntity

class LocalDataSource(private val mMovieDao: MovieDao) {

    companion object {
         private var INSTANCE: LocalDataSource? = null

         fun getInstance(movieDao: MovieDao): LocalDataSource {
             if (INSTANCE == null) {
                 INSTANCE = LocalDataSource(movieDao)
             }
             return INSTANCE as LocalDataSource
         }
     }

    fun getMovies(): DataSource.Factory<Int, MovieEntity> = mMovieDao.getMovies()

    fun getDetailMovie(id: String): LiveData<MovieEntity> = mMovieDao.getDetailMovies(id)

    fun setFavoriteMovie(movie: MovieEntity, newState: Boolean) {
        movie.isFavorite = newState
        mMovieDao.updateMovie(movie)
    }

    fun getFavoriteMovies(): DataSource.Factory<Int, MovieEntity> = mMovieDao.getFavoriteMovies()

    fun getTvShows(): DataSource.Factory<Int, TvShowEntity> = mMovieDao.getTvShows()

    fun getDetailTvShow(id: String): LiveData<TvShowEntity> = mMovieDao.getDetailTvShows(id)

    fun setFavoriteTvShow(tvShow: TvShowEntity, newState: Boolean) {
        tvShow.isFavorite = newState
        mMovieDao.updateTvShow(tvShow)
    }

    fun getFavoriteTvShows(): DataSource.Factory<Int, TvShowEntity> = mMovieDao.getFavoriteTvShows()

    fun insertMovies(movies: List<MovieEntity>) = mMovieDao.insertMovies(movies)

    fun insertTvShows(tvShows: List<TvShowEntity>) = mMovieDao.insertTvShows(tvShows)

    fun updateMovie(movie: MovieEntity, newState: Boolean) {
        movie.isFavorite = newState
        mMovieDao.updateMovie(movie)
    }

    fun updateTvShow(tvShow: TvShowEntity, newState: Boolean) {
        tvShow.isFavorite = newState
        mMovieDao.updateTvShow(tvShow)
    }
}