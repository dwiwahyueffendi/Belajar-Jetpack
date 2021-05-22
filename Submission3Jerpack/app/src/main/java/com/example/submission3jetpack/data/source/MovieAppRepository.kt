package com.example.submission3jetpack.data.source

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.submission3jetpack.data.source.local.LocalDataSource
import com.example.submission3jetpack.data.source.local.entity.MovieEntity
import com.example.submission3jetpack.data.source.local.entity.TvShowEntity
import com.example.submission3jetpack.data.source.remote.ApiResponse
import com.example.submission3jetpack.data.source.remote.RemoteDataSource
import com.example.submission3jetpack.data.source.remote.response.ResultsMovieItem
import com.example.submission3jetpack.data.source.remote.response.ResultsTvShowItem
import com.example.submission3jetpack.vo.Resource
import com.example.submission3jetpack.utils.AppExecutors

class MovieAppRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
    ): MovieAppDataSource {

    companion object {
        @Volatile

        private var instance: MovieAppRepository? = null

        fun getInstance(remoteData: RemoteDataSource, localDataSource: LocalDataSource, appExecutors: AppExecutors): MovieAppRepository =
                instance ?: synchronized(this) {
                    instance ?: MovieAppRepository(remoteData, localDataSource, appExecutors)
                }
    }

    override fun getMovies(sort: String): LiveData<Resource<PagedList<MovieEntity>>> {
        return object : NetworkBoundResource<PagedList<MovieEntity>, List<ResultsMovieItem>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(10)
                    .setPageSize(10)
                    .build()
                return LivePagedListBuilder(localDataSource.getMovies(sort), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<ResultsMovieItem>>> =
                remoteDataSource.getMovies()

            override fun saveCallResult(data: List<ResultsMovieItem>) {
                val listMovies = ArrayList<MovieEntity>()
                for (response in data) {
                    with(response)  {
                        val movie = MovieEntity(
                            id = id,
                            posterPath = posterPath,
                            title = title,
                            voteAverage = voteAverage
                        )
                        listMovies.add(movie)
                    }
                }
                localDataSource.insertMovies(listMovies)
            }
        }.asLiveData()
    }

    override fun getTvShows(sort: String): LiveData<Resource<PagedList<TvShowEntity>>> {
        return object : NetworkBoundResource<PagedList<TvShowEntity>, List<ResultsTvShowItem>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<TvShowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(10)
                    .setPageSize(10)
                    .build()
                return LivePagedListBuilder(localDataSource.getTvShows(sort), config).build()
            }

            override fun shouldFetch(data: PagedList<TvShowEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<ResultsTvShowItem>>> =
                remoteDataSource.getTvShows()

            override fun saveCallResult(data: List<ResultsTvShowItem>) {
                val listTvShows = ArrayList<TvShowEntity>()
                for (response in data) {
                    with(response) {
                        val tvShow = TvShowEntity(
                            id = id,
                            posterPath = posterPath,
                            name = name,
                            voteAverage = voteAverage
                        )
                        listTvShows.add(tvShow)
                    }
                }
                localDataSource.insertTvShows(listTvShows)
            }

        }.asLiveData()
    }

    override fun getDetailMovie(movieId: String): LiveData<Resource<MovieEntity>> {
        return object : NetworkBoundResource<MovieEntity, ResultsMovieItem>(appExecutors) {
            override fun loadFromDB(): LiveData<MovieEntity> =
                localDataSource.getDetailMovieById(movieId)

            override fun shouldFetch(data: MovieEntity?): Boolean =
                data != null && data.genres == "" && data.overview == "" && data.releaseDate == "" &&
                        data.backdropPath == "" && data.runtime == 0

            override fun createCall(): LiveData<ApiResponse<ResultsMovieItem>> =
                remoteDataSource.getDetailMovie(movieId)

            override fun saveCallResult(data: ResultsMovieItem) {
                val listGenres = ArrayList<String>()
                for (i in data.genres.indices) {
                    listGenres.add(data.genres[i].name)
                }

                val detailMovieResult = MovieEntity(
                    title = data.title,
                    backdropPath = data.backdropPath,
                    genres = listGenres.joinToString(),
                    id = data.id,
                    overview = data.overview,
                    runtime = data.runtime,
                    posterPath = data.posterPath,
                    releaseDate = data.releaseDate,
                    voteAverage = data.voteAverage,
                    tagline = data.tagline,
                    isFavorite = false
                )
                localDataSource.updateMovie(detailMovieResult, false)
            }
        }.asLiveData()
    }

    override fun getDetailTvShow(tvShowId: String): LiveData<Resource<TvShowEntity>> {
        return object : NetworkBoundResource<TvShowEntity, ResultsTvShowItem>(appExecutors) {
            override fun loadFromDB(): LiveData<TvShowEntity> =
                localDataSource.getDetailTvShowById(tvShowId)

            override fun shouldFetch(data: TvShowEntity?): Boolean =
                data != null && data.genres == "" && data.overview == "" && data.firstAirDate== "" &&
                        data.backdropPath == ""

            override fun createCall(): LiveData<ApiResponse<ResultsTvShowItem>> =
                remoteDataSource.getDetailTvShow(tvShowId)

            override fun saveCallResult(data: ResultsTvShowItem) {
                val listGenres = ArrayList<String>()
                for (i in data.genres.indices) {
                    listGenres.add(data.genres[i].name)
                }

                val detailTvShowResult = TvShowEntity(
                    backdropPath = data.backdropPath,
                    genres = listGenres.joinToString(),
                    id = data.id,
                    firstAirDate = data.firstAirDate,
                    overview = data.overview,
                    posterPath = data.posterPath,
                    voteAverage = data.voteAverage,
                    name = data.name,
                    tagline = data.tagline,
                    isFavorite = false
                )
                localDataSource.updateTvShow(detailTvShowResult, false)
            }
        }.asLiveData()
    }

    override fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(10)
            .setPageSize(10)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteMovies(), config).build()
    }

    override fun getFavoriteTvShows(): LiveData<PagedList<TvShowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(10)
            .setPageSize(10)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteTvShows(), config).build()
    }

    override fun setFavoriteMovie(movie: MovieEntity, state: Boolean) {
        appExecutors.diskIO().execute {
            localDataSource.setFavoriteMovie(movie, state)
        }
    }

    override fun setFavoriteTvShow(tvShow: TvShowEntity, state: Boolean) {
        appExecutors.diskIO().execute {
            localDataSource.setFavoriteTvShow(tvShow, state)
        }
    }
}