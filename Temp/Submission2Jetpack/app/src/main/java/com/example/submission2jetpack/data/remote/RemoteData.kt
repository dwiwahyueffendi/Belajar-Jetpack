package com.example.submission2jetpack.data.remote

import android.util.Log
import com.example.submission2jetpack.data.remote.response.ListMovieResponse
import com.example.submission2jetpack.data.remote.response.ListTvShowResponse
import com.example.submission2jetpack.data.remote.response.MovieResponse
import com.example.submission2jetpack.data.remote.response.TvShowResponse
import com.example.submission2jetpack.network.ApiConfig
import com.example.submission2jetpack.network.NetworkInfo.API_KEY
import com.example.submission2jetpack.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteData {
    companion object {
        @Volatile
        private var instance: RemoteData? = null

        fun getInstance(): RemoteData = instance ?: synchronized(this) {
                instance ?: RemoteData()
        }
    }

    interface LoadPopularMovie {
        fun onPopularMovie(movieResponse: List<MovieResponse>)
    }

    interface LoadDetailPopularMovie {
        fun onDetailPopularMovie(movieDetailResponse: MovieResponse)
    }

    interface LoadPopularTvShow {
        fun onPopularTvShow(tvShowResponse: List<TvShowResponse>)
    }

    interface LoadDetailPopularTvShow {
        fun onDetailPopularTvShow(tvShowDetailResponse: TvShowResponse)
    }

    fun getMovie(callback: LoadPopularMovie) {
        EspressoIdlingResource.increment()
        val client = ApiConfig.getApiService().getMovie(API_KEY)
        client.enqueue(object : Callback<ListMovieResponse> {
            override fun onResponse(call: Call<ListMovieResponse>, response: Response<ListMovieResponse>) {
                response.body()?.let { callback.onPopularMovie(it.result) }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<ListMovieResponse>, t: Throwable) {
                Log.e("RemoteData", "getMovie onFailure : ${t.message}")
                EspressoIdlingResource.decrement()
            }
        })
    }

    fun getDetailMovie(callback: LoadDetailPopularMovie, id: String) {
        EspressoIdlingResource.increment()
        val client = ApiConfig.getApiService().getMovieDetail(id, API_KEY)
        client.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                response.body()?.let { callback.onDetailPopularMovie(it) }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e("RemoteData", "getMovieDetail onFailure : ${t.message}")
                EspressoIdlingResource.decrement()
            }
        })
    }

    fun getTvShow(callback: LoadPopularTvShow) {
        EspressoIdlingResource.increment()
        val client = ApiConfig.getApiService().getTvShow(API_KEY)
        client.enqueue(object : Callback<ListTvShowResponse> {
            override fun onResponse(call: Call<ListTvShowResponse>, response: Response<ListTvShowResponse>) {
                response.body()?.let { callback.onPopularTvShow(it.result) }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<ListTvShowResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "getTvShows onFailure : ${t.message}")
                EspressoIdlingResource.decrement()
            }
        })
    }

    fun getDetailTvShow(callback: LoadDetailPopularTvShow, id: String) {
        EspressoIdlingResource.increment()
        val client = ApiConfig.getApiService().getTvShowDetail(id, API_KEY)
        client.enqueue(object : Callback<TvShowResponse> {
            override fun onResponse(call: Call<TvShowResponse>, response: Response<TvShowResponse>) {
                response.body()?.let { callback.onDetailPopularTvShow(it) }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                Log.e("RemoteData", "getDetailTvShow onFailure : ${t.message}")
                EspressoIdlingResource.decrement()
            }
        })
    }
}