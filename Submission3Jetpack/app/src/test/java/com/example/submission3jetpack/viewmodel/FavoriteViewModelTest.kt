package com.example.submission3jetpack.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.example.submission3jetpack.data.source.ContentRepository
import com.example.submission3jetpack.data.source.local.entity.MovieEntity
import com.example.submission3jetpack.data.source.local.entity.TvShowEntity
import com.example.submission3jetpack.utils.DataDummy
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteViewModelTest {

    private lateinit var viewModel: FavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var mContentRepository: ContentRepository

    @Mock
    private lateinit var observerMovie: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var observerTvShow: Observer<PagedList<TvShowEntity>>

    @Mock
    private lateinit var pagedListMovie: PagedList<MovieEntity>

    @Mock
    private lateinit var pagedListTvShow: PagedList<TvShowEntity>

    @Before
    fun setup() {
        viewModel = FavoriteViewModel(mContentRepository)
    }

    @Test
    fun testSetFavoriteMovie() {
        viewModel.setFavoriteMovie(DataDummy.generateDetailMovie())
        verify(mContentRepository).setFavoriteMovie(DataDummy.generateDetailMovie(), true)
        verifyNoMoreInteractions(mContentRepository)
    }

    @Test
    fun testSetFavoriteTvShow() {
        viewModel.setFavoriteTvShow(DataDummy.generateDetailTvShow())
        verify(mContentRepository).setFavoriteTvShow(DataDummy.generateDetailTvShow(), true)
        verifyNoMoreInteractions(mContentRepository)
    }

    @Test
    fun testGetFavoriteMovies() {
        val dummyMovies = pagedListMovie
        Mockito.`when`(dummyMovies.size).thenReturn(6)
        val movies =  MutableLiveData<PagedList<MovieEntity>>()
        movies.value = dummyMovies

        Mockito.`when`(mContentRepository.getFavoriteMovies()).thenReturn(movies)
        val movieEntities = viewModel.getFavoriteMovies().value
        verify(mContentRepository).getFavoriteMovies()
        Assert.assertNotNull(movieEntities)
        Assert.assertEquals(6, movieEntities?.size)

        viewModel.getFavoriteMovies().observeForever(observerMovie)
        verify(observerMovie).onChanged(dummyMovies)
    }

    @Test
    fun testGetFavoriteTvShows() {
        val dummyTvshow = pagedListTvShow
        Mockito.`when`(dummyTvshow.size).thenReturn(6)
        val tvShows =  MutableLiveData<PagedList<TvShowEntity>>()
        tvShows.value = dummyTvshow

        Mockito.`when`(mContentRepository.getFavoriteTvShows()).thenReturn(tvShows)
        val tvShowEntities = viewModel.getFavoriteTvShows().value
        verify(mContentRepository).getFavoriteTvShows()
        Assert.assertNotNull(tvShowEntities)
        Assert.assertEquals(6, tvShowEntities?.size)

        viewModel.getFavoriteTvShows().observeForever(observerTvShow)
        verify(observerTvShow).onChanged(dummyTvshow)
    }
}