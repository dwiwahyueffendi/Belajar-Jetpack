package com.example.myapplication.network

import com.example.myapplication.data.remote.response.*
import com.example.myapplication.network.NetworkInfo.API_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movie/now_playing")
    fun getPlayingMovies(
        @Query("api_key") apiKey: String
    ) : Call<ListResponse<MovieResponse>>

    @GET("movie/{movie_id}")
    fun getDetailMovie(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String
    ) : Call<MovieResponse>

    @GET("tv/on_the_air")
    fun getPlayingTvShow(
        @Query("api_key") apiKey: String
    ) : Call<ListResponse<TvShowResponse>>

    @GET("tv/{tv_id}")
    fun getDetailTvShow(
        @Path("tv_id") tvShowId: Int,
        @Query("api_key") apiKey: String
    ) : Call<TvShowResponse>
}