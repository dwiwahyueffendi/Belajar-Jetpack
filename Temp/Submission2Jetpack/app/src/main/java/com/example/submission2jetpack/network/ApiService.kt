package com.example.submission2jetpack.network

import com.example.submission2jetpack.data.remote.response.ListMovieResponse
import com.example.submission2jetpack.data.remote.response.ListTvShowResponse
import com.example.submission2jetpack.data.remote.response.MovieResponse
import com.example.submission2jetpack.data.remote.response.TvShowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    fun getMovie(
        @Query("api_key") apiKey: String
    ) : Call<ListMovieResponse>

    @GET("movie/{id}")
    fun getMovieDetail(
        @Path("id") id: String,
        @Query("api_key") apiKey: String
    ) : Call<MovieResponse>

    @GET("tv/popular")
    fun getTvShow(
        @Query("api_key") apiKey: String
    ) : Call<ListTvShowResponse>

    @GET("tv/{id}")
    fun getTvShowDetail(
        @Path("id") id: String,
        @Query("api_key") apiKey: String
    ) : Call<TvShowResponse>
}