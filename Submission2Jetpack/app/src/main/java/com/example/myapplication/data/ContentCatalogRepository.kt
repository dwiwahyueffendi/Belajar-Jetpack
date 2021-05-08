package com.example.myapplication.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.data.local.ContentEntity
import com.example.myapplication.data.remote.RemoteDataSource
import com.example.myapplication.data.remote.response.MovieResponse
import com.example.myapplication.data.remote.response.TvShowResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class ContentCatalogRepository private constructor(private val remoteDataSource: RemoteDataSource) : ContentCatalogDataSource {

    companion object {
        @Volatile
        private var instance: ContentCatalogRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource): ContentCatalogRepository =
            instance ?: synchronized(this) {
                instance ?: ContentCatalogRepository(remoteDataSource)
            }
    }

    override fun getPlayingMovies(): LiveData<List<ContentEntity>> {
        val listMovie = MutableLiveData<List<ContentEntity>>()
        CoroutineScope(IO).launch {
            remoteDataSource.getPlayingMovies(object : RemoteDataSource.LoadPlayingMovie{
                override fun onAllMovies(movieResponse: List<MovieResponse>) {
                    val movieList = ArrayList<ContentEntity>()
                    for (data in movieResponse){
                        val movie = ContentEntity(
                            data.id,
                            data.title,
                            data.desc,
                            data.posterPath,
                            data.backdropPath
                        )
                        movieList.add(movie)
                    }
                    listMovie.postValue(movieList)
                }
            })
        }

        return listMovie
    }

    override fun getMovieDetail(movieId: Int): LiveData<ContentEntity> {
        val movieResult = MutableLiveData<ContentEntity>()
        CoroutineScope(IO).launch {
            remoteDataSource.getMovieDetail(movieId, object : RemoteDataSource.LoadMovieDetail{
                override fun onMovieDetail(movieResponse: MovieResponse) {
                    val movie = ContentEntity(
                        movieResponse.id,
                        movieResponse.title,
                        movieResponse.desc,
                        movieResponse.posterPath,
                        movieResponse.backdropPath
                    )
                    movieResult.postValue(movie)
                }
            })
        }
        return movieResult
    }

    override fun getPlayingTvShow(): LiveData<List<ContentEntity>> {
        val listTvShow = MutableLiveData<List<ContentEntity>>()
        CoroutineScope(IO).launch {
            remoteDataSource.getPlayingTvShow(object : RemoteDataSource.LoadPlayingTvShow{
                override fun onAllTvShow(tvShowResponse: List<TvShowResponse>) {
                    val tvShowList = ArrayList<ContentEntity>()
                    for (data in tvShowResponse){
                        val tvShow = ContentEntity(
                            data.id,
                            data.name,
                            data.desc,
                            data.posterPath,
                            data.backdropPath
                        )
                        tvShowList.add(tvShow)
                    }

                    listTvShow.postValue(tvShowList)
                }
            })
        }

        return listTvShow
    }

    override fun getTvShowDetail(tvShowId: Int): LiveData<ContentEntity> {
        val tvShowResult = MutableLiveData<ContentEntity>()
        CoroutineScope(IO).launch {
            remoteDataSource.getTvShowDetail(tvShowId, object : RemoteDataSource.LoadTvShowDetail{
                override fun onTvShowDetail(tvShowResponse: TvShowResponse) {
                    val tvShow = ContentEntity(
                        tvShowResponse.id,
                        tvShowResponse.name,
                        tvShowResponse.desc,
                        tvShowResponse.posterPath,
                        tvShowResponse.backdropPath
                    )

                    tvShowResult.postValue(tvShow)
                }
            })
        }

        return tvShowResult
    }
}