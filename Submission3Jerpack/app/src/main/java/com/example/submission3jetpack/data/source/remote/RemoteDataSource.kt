package com.example.submission3jetpack.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.submission3jetpack.data.source.remote.response.MovieResponse
import com.example.submission3jetpack.data.source.remote.response.ResultsMovieItem
import com.example.submission3jetpack.data.source.remote.response.ResultsTvShowItem
import com.example.submission3jetpack.data.source.remote.response.TvShowResponse
import com.example.submission3jetpack.network.ApiConfig
import com.example.submission3jetpack.network.NetworkInfo.API_KEY
import com.example.submission3jetpack.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {

    companion object {
        private const val TAG = "RemoteDataSource"

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
                instance ?: synchronized(this) {
                    instance ?: RemoteDataSource()
                }
    }

    fun getMovies(): LiveData<ApiResponse<List<ResultsMovieItem>>> {
        EspressoIdlingResource.increment()
        val resultMovies = MutableLiveData<ApiResponse<List<ResultsMovieItem>>>()
        val client = ApiConfig.getApiService().getMovies(API_KEY)

        client.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                resultMovies.value = ApiResponse.success(response.body()?.results as List<ResultsMovieItem>)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.d(TAG, "onFailure :${t.message}" )
                EspressoIdlingResource.decrement()
            }
        })
        return resultMovies
    }

    fun getTvShows(): LiveData<ApiResponse<List<ResultsTvShowItem>>> {
        EspressoIdlingResource.increment()
        val resultTvShows = MutableLiveData<ApiResponse<List<ResultsTvShowItem>>>()
        val client = ApiConfig.getApiService().getTvShows(API_KEY)
        client.enqueue(object : Callback<TvShowResponse> {
            override fun onResponse(call: Call<TvShowResponse>, response: Response<TvShowResponse>) {
                resultTvShows.value = ApiResponse.success(response.body()?.results as List<ResultsTvShowItem>)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                Log.d(TAG, "onFailure :${t.message}" )
                EspressoIdlingResource.decrement()
            }
        })
        return resultTvShows
    }

    fun getDetailMovie(movieId: String): LiveData<ApiResponse<ResultsMovieItem>> {
        EspressoIdlingResource.increment()
        val resultDetailMovie = MutableLiveData<ApiResponse<ResultsMovieItem>>()
        val client = ApiConfig.getApiService().getDetailMovie(movieId, API_KEY)
        client.enqueue(object : Callback<ResultsMovieItem> {
            override fun onResponse(call: Call<ResultsMovieItem>, response: Response<ResultsMovieItem>) {
                resultDetailMovie.value = ApiResponse.success(response.body() as ResultsMovieItem)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<ResultsMovieItem>, t: Throwable) {
                Log.d(TAG, "onFailure :${t.message}" )
                EspressoIdlingResource.decrement()
            }
        })
        return resultDetailMovie
    }

    fun getDetailTvShow(tvShowId: String): LiveData<ApiResponse<ResultsTvShowItem>> {
        EspressoIdlingResource.increment()
        val resultDetailTvShow =  MutableLiveData<ApiResponse<ResultsTvShowItem>>()
        val client = ApiConfig.getApiService().getDetailTvShow(tvShowId, API_KEY)
        client.enqueue(object : Callback<ResultsTvShowItem> {
            override fun onResponse(call: Call<ResultsTvShowItem>, response: Response<ResultsTvShowItem>) {
                resultDetailTvShow.value = ApiResponse.success(response.body() as ResultsTvShowItem)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<ResultsTvShowItem>, t: Throwable) {
                Log.d(TAG, "onFailure :${t.message}" )
                EspressoIdlingResource.decrement()
            }
        })
        return resultDetailTvShow
    }
}