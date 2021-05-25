package com.example.submission3jetpack.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.submission3jetpack.data.source.local.LocalDataSource
import com.example.submission3jetpack.data.source.local.entity.MovieEntity
import com.example.submission3jetpack.data.source.local.entity.TvShowEntity
import com.example.submission3jetpack.data.source.remote.RemoteDataSource
import com.example.submission3jetpack.utils.AppExecutors
import com.example.submission3jetpack.utils.DataDummy
import com.example.submission3jetpack.utils.LiveDataTestUtil
import com.example.submission3jetpack.utils.PagedListUtil
import com.example.submission3jetpack.vo.Resource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

class ContentRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val mFakeContentRepository = FakeContentRepository(remote, local, appExecutors)

    private val movieResponse = DataDummy.generateRemoteDummyMovies()
    private val movieId = movieResponse[0].id
    private val detailMovieResponse = DataDummy.generateRemoteDetailMovie()

    private val tvShowResponse = DataDummy.generateRemoteDummyTvShows()
    private val tvShowId = tvShowResponse[0].id
    private val detailTvShowResponse = DataDummy.generateRemoteDetailTvShow()

    @Test
    fun testGetMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getMovies()).thenReturn(dataSourceFactory)
        mFakeContentRepository.getMovies()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getMovies()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun testGetDetailMovie() {
        val dummyDetailMovie = MutableLiveData<MovieEntity>()
        dummyDetailMovie.value = DataDummy.generateDetailMovie()
        `when`(local.getDetailMovie(movieId)).thenReturn(dummyDetailMovie)

        val detailMovieEntity = LiveDataTestUtil.getValue(mFakeContentRepository.getDetailMovie(movieId))
        verify(local).getDetailMovie((movieId))
        assertNotNull(detailMovieEntity)
        assertEquals(detailMovieResponse.id, detailMovieEntity.data?.id)
        assertEquals(detailMovieResponse.title, detailMovieEntity.data?.title)
        assertEquals(detailMovieResponse.overview, detailMovieEntity.data?.overview)
        assertEquals(detailMovieResponse.releaseDate, detailMovieEntity.data?.releaseDate)
        assertEquals(detailMovieResponse.voteAverage, detailMovieEntity.data?.voteAverage)
    }

    @Test
    fun testGetTvShows() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getTvShows()).thenReturn(dataSourceFactory)
        mFakeContentRepository.getTvShows()

        val tvShowEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShows()))
        verify(local).getTvShows()
        assertNotNull(tvShowEntities.data)
        assertEquals(tvShowResponse.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun testGetDetailTvShow() {
        val dummyDetailTvShow = MutableLiveData<TvShowEntity>()
        dummyDetailTvShow.value = DataDummy.generateDetailTvShow()
        `when`(local.getDetailTvShow(tvShowId)).thenReturn(dummyDetailTvShow)

        val detailTvShowEntity = LiveDataTestUtil.getValue(mFakeContentRepository.getDetailTvShow(tvShowId))
        verify(local).getDetailTvShow(tvShowId)
        assertNotNull(detailTvShowEntity)
        assertEquals(detailTvShowResponse.id, detailTvShowEntity.data?.id)
        assertEquals(detailTvShowResponse.name, detailTvShowEntity.data?.name)
        assertEquals(detailTvShowResponse.overview, detailTvShowEntity.data?.overview)
        assertEquals(detailTvShowResponse.firstAirDate, detailTvShowEntity.data?.firstAirDate)
        assertEquals(detailTvShowResponse.voteAverage, detailTvShowEntity.data?.voteAverage)
    }

    @Test
    fun testSetFavoriteMovie() {
        mFakeContentRepository.setFavoriteMovie(DataDummy.generateDetailMovie(), true)
        verify(local).setFavoriteMovie(DataDummy.generateDetailMovie(), true)
        verifyNoMoreInteractions(local)
    }

    @Test
    fun testGetFavoriteMovies(){
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getFavoriteMovies()).thenReturn(dataSourceFactory)
        mFakeContentRepository.getFavoriteMovies()

        val movieEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getFavoriteMovies()
        assertNotNull(movieEntity.data)
        assertEquals(movieResponse.size.toLong(), movieEntity.data?.size?.toLong())
    }

    @Test
    fun testSetFavoriteTvShow() {
        mFakeContentRepository.setFavoriteTvShow(DataDummy.generateDetailTvShow(), true)
        verify(local).setFavoriteTvShow(DataDummy.generateDetailTvShow(), true)
        verifyNoMoreInteractions(local)
    }

    @Test
    fun testGetFavoriteTvShow(){
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getFavoriteTvShows()).thenReturn(dataSourceFactory)
        mFakeContentRepository.getFavoriteTvShows()

        val movieEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getFavoriteTvShows()
        assertNotNull(movieEntity.data)
        assertEquals(movieResponse.size.toLong(), movieEntity.data?.size?.toLong())
    }
}