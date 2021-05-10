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
                        with(data){
                            val movie = ContentEntity(backdropPath, id, desc, posterPath, releaseDate, title, voteAverage)
                            movieList.add(movie)
                        }
                    }
                    listMovie.postValue(movieList)
                }
            })
        }
        return listMovie
    }

    override fun getMovieDetail(movieId: Int): LiveData<ContentEntity> {
        val listDetailMovie = MutableLiveData<ContentEntity>()
        CoroutineScope(IO).launch {
            remoteDataSource.getMovieDetail(movieId, object : RemoteDataSource.LoadMovieDetail{
                override fun onMovieDetail(movieResponse: MovieResponse) {
                    with(movieResponse){
                        val movie = ContentEntity(backdropPath, id, desc, posterPath, releaseDate, title, voteAverage)
                        listDetailMovie.postValue(movie)
                    }
                }
            })
        }
        return listDetailMovie
    }

    override fun getPlayingTvShow(): LiveData<List<ContentEntity>> {
        val listTvShow = MutableLiveData<List<ContentEntity>>()
        CoroutineScope(IO).launch {
            remoteDataSource.getPlayingTvShow(object : RemoteDataSource.LoadPlayingTvShow{
                override fun onAllTvShow(tvShowResponse: List<TvShowResponse>) {
                    val tvShowList = ArrayList<ContentEntity>()
                    for (data in tvShowResponse){
                        with(data){
                            val tvShow = ContentEntity(backdropPath, id, desc, posterPath, releaseDate, title, voteAverage)
                            tvShowList.add(tvShow)
                        }
                    }
                    listTvShow.postValue(tvShowList)
                }
            })
        }
        return listTvShow
    }

    override fun getTvShowDetail(tvShowId: Int): LiveData<ContentEntity> {
        val listDetailTvShow = MutableLiveData<ContentEntity>()
        CoroutineScope(IO).launch {
            remoteDataSource.getTvShowDetail(tvShowId, object : RemoteDataSource.LoadTvShowDetail{
                override fun onTvShowDetail(tvShowResponse: TvShowResponse) {
                    with(tvShowResponse){
                        val tvShow = ContentEntity(backdropPath, id, desc, posterPath, releaseDate, title, voteAverage)
                        listDetailTvShow.postValue(tvShow)
                    }
                }
            })
        }
        return listDetailTvShow
    }
}