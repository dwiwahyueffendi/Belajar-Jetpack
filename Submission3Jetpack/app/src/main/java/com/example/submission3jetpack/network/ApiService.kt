package com.example.submission3jetpack.network

import com.example.submission3jetpack.data.source.remote.response.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movie/now_playing")
    fun getMovies(
        @Query("api_key") apiKey: String
    ): Call<MovieResponse>

    @GET("movie/{movie_id}")
    fun getDetailMovie(
        @Path("movie_id") movieId: String,
        @Query("api_key") apiKey: String
    ): Call<ListMovieResponse>

    @GET("tv/on_the_air")
    fun getTvShows(
        @Query("api_key") apiKey: String
    ): Call<TvShowResponse>

    @GET("tv/{tvShow_id}")
    fun getDetailTvShow(
        @Path("tvShow_id") tvShowId: String,
        @Query("api_key") apiKey: String
    ): Call<ListTvShowResponse>
}