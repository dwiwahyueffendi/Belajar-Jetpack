package com.example.submission2jetpack.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.submission2jetpack.data.local.DetailEntity
import com.example.submission2jetpack.data.local.MovieEntity
import com.example.submission2jetpack.data.local.TvShowEntity
import com.example.submission2jetpack.data.remote.RemoteData
import com.example.submission2jetpack.data.remote.response.MovieResponse
import com.example.submission2jetpack.data.remote.response.TvShowResponse

class ContentRepository private constructor(private val remoteData: RemoteData) : ContentDataSource{
    companion object {
        @Volatile
        private var instance: ContentRepository? = null
        fun getInstance(remoteData: RemoteData): ContentRepository =
            instance ?: synchronized(this) {
                instance ?: ContentRepository(remoteData)
            }
    }

    override fun getMovie(): LiveData<List<MovieEntity>> {
        val resultMovie = MutableLiveData<List<MovieEntity>>()

        remoteData.getMovie(object : RemoteData.LoadPopularMovie {
            override fun onPopularMovie(movieResponse: List<MovieResponse>) {
                val listMovie = ArrayList<MovieEntity>()
                for (response in movieResponse) {
                    with(response) {
                        val addMovie = MovieEntity(backdropPath, id, desc, posterPath, releaseDate, title, voteAverage)
                        listMovie.add(addMovie)
                    }
                }
                resultMovie.postValue(listMovie)
            }
        })
        return resultMovie
    }

    override fun getTvShow(): LiveData<List<TvShowEntity>> {
        val resultTvShow = MutableLiveData<List<TvShowEntity>>()

        remoteData.getTvShow(object : RemoteData.LoadPopularTvShow {
            override fun onPopularTvShow(tvShowResponse: List<TvShowResponse>) {
                val listTvShow = ArrayList<TvShowEntity>()
                for (response in tvShowResponse) {
                    with(response) {
                        val addTvShow = TvShowEntity(backdropPath, id, name, desc, posterPath, releaseDate, voteAverage)
                        listTvShow.add(addTvShow)
                    }
                }
                resultTvShow.postValue(listTvShow)
            }

        })
        return resultTvShow
    }

    override fun getDetailMovie(idMovie: String): LiveData<DetailEntity> {
        val resultDetailMovie = MutableLiveData<DetailEntity>()

        remoteData.getDetailMovie(object : RemoteData.LoadDetailPopularMovie {
            override fun onDetailPopularMovie(movieDetailResponse: MovieResponse) {
                with(movieDetailResponse) {
                    val addDetailMovie = DetailEntity(backdropPath, id, desc, posterPath, releaseDate, title, voteAverage)
                    resultDetailMovie.postValue(addDetailMovie)
                }
            }
        }, idMovie)
        return resultDetailMovie
    }

    override fun getDetailTvShow(idTvShow: String): LiveData<DetailEntity> {
        val resultDetailTvShow = MutableLiveData<DetailEntity>()

        remoteData.getDetailTvShow(object : RemoteData.LoadDetailPopularTvShow {
            override fun onDetailPopularTvShow(tvShowDetailResponse: TvShowResponse) {
                with(tvShowDetailResponse) {
                    val addDetailTvShow = DetailEntity(backdropPath, id, name, desc, posterPath, releaseDate, voteAverage)
                    resultDetailTvShow.postValue(addDetailTvShow)
                }
            }
        }, idTvShow)
        return resultDetailTvShow
    }
}