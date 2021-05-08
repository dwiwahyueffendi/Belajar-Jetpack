package com.example.myapplication.data.remote

import com.example.myapplication.network.ApiConfig
import com.example.myapplication.data.remote.response.MovieResponse
import com.example.myapplication.data.remote.response.TvShowResponse
import com.example.myapplication.network.NetworkInfo.API_KEY
import com.example.myapplication.utils.EspressoIdlingResource
import retrofit2.await

class RemoteDataSource {

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource()
            }
    }

    interface LoadPlayingMovie {
        fun onAllMovies(movieResponse: List<MovieResponse>)
    }

    interface LoadMovieDetail {
        fun onMovieDetail(movieResponse: MovieResponse)
    }

    interface LoadPlayingTvShow {
        fun onAllTvShow(tvShowResponse: List<TvShowResponse>)
    }

    interface LoadTvShowDetail {
        fun onTvShowDetail(tvShowResponse: TvShowResponse)
    }

    suspend fun getPlayingMovies(callback: LoadPlayingMovie) {
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getPlayingMovies(API_KEY).await().result?.let { listMovie ->
            callback.onAllMovies(listMovie)
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getMovieDetail(movieId: Int, callback: LoadMovieDetail) {
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getDetailMovie(movieId, API_KEY).await().let { movie ->
            callback.onMovieDetail(movie)
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getPlayingTvShow(callback: LoadPlayingTvShow) {
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getPlayingTvShow(API_KEY).await().result?.let { listTvShow ->
            callback.onAllTvShow(listTvShow)
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getTvShowDetail(tvShowId: Int, callback: LoadTvShowDetail) {
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getDetailTvShow(tvShowId, API_KEY).await().let { tvShow ->
            callback.onTvShowDetail(tvShow)
            EspressoIdlingResource.decrement()
        }
    }
}