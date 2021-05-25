package com.example.submission3jetpack.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.submission3jetpack.data.source.remote.response.MovieResponse
import com.example.submission3jetpack.data.source.remote.response.ListMovieResponse
import com.example.submission3jetpack.data.source.remote.response.ListTvShowResponse
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

    fun getMovies(): LiveData<ApiResponse<List<ListMovieResponse>>> {
        EspressoIdlingResource.increment()
        val movies = MutableLiveData<ApiResponse<List<ListMovieResponse>>>()

        ApiConfig.getApiService().getMovies(API_KEY).enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                movies.value =
                    ApiResponse.success(response.body()?.results as List<ListMovieResponse>)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.d(TAG, "onFailure :${t.message}")
                EspressoIdlingResource.decrement()
            }
        })
        return movies
    }

    fun getDetailMovie(movieId: String): LiveData<ApiResponse<ListMovieResponse>> {
        EspressoIdlingResource.increment()
        val detailMovies = MutableLiveData<ApiResponse<ListMovieResponse>>()

        ApiConfig.getApiService().getDetailMovie(movieId, API_KEY)
            .enqueue(object : Callback<ListMovieResponse> {
                override fun onResponse(
                    call: Call<ListMovieResponse>,
                    response: Response<ListMovieResponse>
                ) {
                    detailMovies.value = ApiResponse.success(response.body() as ListMovieResponse)
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<ListMovieResponse>, t: Throwable) {
                    Log.d(TAG, "onFailure :${t.message}")
                    EspressoIdlingResource.decrement()
                }
            })
        return detailMovies
    }

    fun getTvShows(): LiveData<ApiResponse<List<ListTvShowResponse>>> {
        EspressoIdlingResource.increment()
        val tvshow = MutableLiveData<ApiResponse<List<ListTvShowResponse>>>()

        ApiConfig.getApiService().getTvShows(API_KEY).enqueue(object : Callback<TvShowResponse> {
            override fun onResponse(
                call: Call<TvShowResponse>,
                response: Response<TvShowResponse>
            ) {
                tvshow.value =
                    ApiResponse.success(response.body()?.results as List<ListTvShowResponse>)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                Log.d(TAG, "onFailure :${t.message}")
                EspressoIdlingResource.decrement()
            }
        })
        return tvshow
    }

    fun getDetailTvShow(tvShowId: String): LiveData<ApiResponse<ListTvShowResponse>> {
        EspressoIdlingResource.increment()
        val detailTvShow = MutableLiveData<ApiResponse<ListTvShowResponse>>()

        ApiConfig.getApiService().getDetailTvShow(tvShowId, API_KEY)
            .enqueue(object : Callback<ListTvShowResponse> {
                override fun onResponse(
                    call: Call<ListTvShowResponse>,
                    response: Response<ListTvShowResponse>
                ) {
                    detailTvShow.value = ApiResponse.success(response.body() as ListTvShowResponse)
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<ListTvShowResponse>, t: Throwable) {
                    Log.d(TAG, "onFailure :${t.message}")
                    EspressoIdlingResource.decrement()
                }
            })
        return detailTvShow
    }
}