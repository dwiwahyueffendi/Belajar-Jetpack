package com.example.submission3jetpack.data

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.submission3jetpack.data.source.ContentDataSource
import com.example.submission3jetpack.data.source.NetworkBoundResource
import com.example.submission3jetpack.data.source.local.LocalDataSource
import com.example.submission3jetpack.data.source.local.entity.MovieEntity
import com.example.submission3jetpack.data.source.local.entity.TvShowEntity
import com.example.submission3jetpack.data.source.remote.ApiResponse
import com.example.submission3jetpack.data.source.remote.RemoteDataSource
import com.example.submission3jetpack.data.source.remote.response.ListMovieResponse
import com.example.submission3jetpack.data.source.remote.response.ListTvShowResponse
import com.example.submission3jetpack.vo.Resource
import com.example.submission3jetpack.utils.AppExecutors

class FakeContentRepository constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
): ContentDataSource {

    companion object {
        @Volatile

        private var instance: FakeContentRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localDataSource: LocalDataSource,
            appExecutors: AppExecutors
        ): FakeContentRepository = instance ?: synchronized(this) {
            instance ?: FakeContentRepository(
                remoteData,
                localDataSource,
                appExecutors
            )
        }
    }

    override fun getMovies(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object : NetworkBoundResource<PagedList<MovieEntity>, List<ListMovieResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val pagedList = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(10)
                    .setPageSize(10)
                    .build()
                return LivePagedListBuilder(localDataSource.getMovies(), pagedList).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean = data.isNullOrEmpty()

            override fun createCall(): LiveData<ApiResponse<List<ListMovieResponse>>> = remoteDataSource.getMovies()

            override fun saveCallResult(data: List<ListMovieResponse>) {
                val listMovies = ArrayList<MovieEntity>()
                for (listMovie in data) {
                    with(listMovie)  {
                        val movie = MovieEntity(id, posterPath, title, backdropPath, overview, releaseDate, voteAverage)
                        listMovies.add(movie)
                    }
                }
                localDataSource.insertMovies(listMovies)
            }
        }.asLiveData()
    }

    override fun getDetailMovie(movieId: String): LiveData<Resource<MovieEntity>> {
        return object : NetworkBoundResource<MovieEntity, ListMovieResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<MovieEntity> = localDataSource.getDetailMovie(movieId)

            override fun shouldFetch(data: MovieEntity?): Boolean = data != null && data.overview == "" && data.releaseDate == "" && data.backdropPath == ""

            override fun createCall(): LiveData<ApiResponse<ListMovieResponse>> = remoteDataSource.getDetailMovie(movieId)

            override fun saveCallResult(data: ListMovieResponse) {
                with(data){
                    val listDetailMovie = MovieEntity(id, posterPath, title, backdropPath, overview, releaseDate, voteAverage, isFavorite = false)
                    localDataSource.updateMovie(listDetailMovie, false)
                }
            }
        }.asLiveData()
    }

    override fun getTvShows(): LiveData<Resource<PagedList<TvShowEntity>>> {
        return object : NetworkBoundResource<PagedList<TvShowEntity>, List<ListTvShowResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<TvShowEntity>> {
                val pagedList = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(10)
                    .setPageSize(10)
                    .build()
                return LivePagedListBuilder(localDataSource.getTvShows(), pagedList).build()
            }

            override fun shouldFetch(data: PagedList<TvShowEntity>?): Boolean = data.isNullOrEmpty()

            override fun createCall(): LiveData<ApiResponse<List<ListTvShowResponse>>> = remoteDataSource.getTvShows()

            override fun saveCallResult(data: List<ListTvShowResponse>) {
                val listTvShows = ArrayList<TvShowEntity>()
                for (listTvShow in data) {
                    with(listTvShow) {
                        val tvShow = TvShowEntity(id, posterPath, name, backdropPath, overview, firstAirDate, voteAverage)
                        listTvShows.add(tvShow)
                    }
                }
                localDataSource.insertTvShows(listTvShows)
            }
        }.asLiveData()
    }


    override fun getDetailTvShow(tvShowId: String): LiveData<Resource<TvShowEntity>> {
        return object : NetworkBoundResource<TvShowEntity, ListTvShowResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<TvShowEntity> = localDataSource.getDetailTvShow(tvShowId)

            override fun shouldFetch(data: TvShowEntity?): Boolean = data != null && data.overview == "" && data.firstAirDate== "" && data.backdropPath == ""

            override fun createCall(): LiveData<ApiResponse<ListTvShowResponse>> = remoteDataSource.getDetailTvShow(tvShowId)

            override fun saveCallResult(data: ListTvShowResponse) {
                with(data){
                    val listDetailTvShow = TvShowEntity(id, posterPath, name, backdropPath, overview, firstAirDate, voteAverage, isFavorite = false)
                    localDataSource.updateTvShow(listDetailTvShow, false)
                }
            }
        }.asLiveData()
    }

    override fun setFavoriteTvShow(tvShow: TvShowEntity, state: Boolean) = localDataSource.setFavoriteTvShow(tvShow, state)

    override fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>> {
        val pagedList = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(10)
            .setPageSize(10)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteMovies(), pagedList).build()
    }

    override fun setFavoriteMovie(movie: MovieEntity, state: Boolean) = localDataSource.setFavoriteMovie(movie, state)

    override fun getFavoriteTvShows(): LiveData<PagedList<TvShowEntity>> {
        val pagedList = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(10)
            .setPageSize(10)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteTvShows(), pagedList).build()
    }
}