package com.example.submission3jetpack.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.example.submission3jetpack.data.source.local.entity.TvShowEntity
import com.example.submission3jetpack.data.source.local.entity.MovieEntity

@Dao
interface MovieDao {

    @Query("SELECT * FROM movieEntities")
    fun getMovies() : DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tvShowEntities")
    fun  getTvShows() : DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM movieEntities WHERE id = :id")
    fun getDetailMovies(id: String): LiveData<MovieEntity>

    @Query("SELECT * FROM tvShowEntities WHERE id = :id")
    fun getDetailTvShows(id: String): LiveData<TvShowEntity>

    @Query("SELECT * FROM movieEntities WHERE isFavorite = 1")
    fun getFavoriteMovies(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tvShowEntities WHERE isFavorite = 1")
    fun getFavoriteTvShows(): DataSource.Factory<Int, TvShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShows(tvShows: List<TvShowEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)

    @Update
    fun updateTvShow(tvShow: TvShowEntity)
}