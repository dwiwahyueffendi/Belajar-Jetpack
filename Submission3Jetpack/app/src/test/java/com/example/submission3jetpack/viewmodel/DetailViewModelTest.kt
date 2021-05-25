package com.example.submission3jetpack.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.submission3jetpack.data.source.ContentRepository
import com.example.submission3jetpack.data.source.local.entity.MovieEntity
import com.example.submission3jetpack.data.source.local.entity.TvShowEntity
import com.example.submission3jetpack.utils.DataDummy
import com.example.submission3jetpack.vo.Resource
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
class DetailViewModelTest {
    private lateinit var viewModel: DetailViewModel

    private val dummyMovie = DataDummy.generateDetailMovie()
    private val movieId = dummyMovie.id
    private val dummyTvShow = DataDummy.generateDetailTvShow()
    private val tvShowId = dummyTvShow.id
    
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var mContentRepository: ContentRepository

    @Mock
    private lateinit var observerMovie: Observer<Resource<MovieEntity>>

    @Mock
    private lateinit var observerTvShow: Observer<Resource<TvShowEntity>>
    
    @Before
    fun setup() {
        viewModel = DetailViewModel(mContentRepository)
    }

    @Test
    fun testGetMovies() {
        val dummyMovie = Resource.success(DataDummy.generateDetailMovie())
        val movie = MutableLiveData<Resource<MovieEntity>>()
        movie.value = dummyMovie

        Mockito.`when`(mContentRepository.getDetailMovie(movieId)).thenReturn(movie)
        viewModel.setSelectMovie(movieId)
        viewModel.detailMovie.observeForever(observerMovie)
        verify(observerMovie).onChanged(dummyMovie)
    }

    @Test
    fun testGetTvShow() {
        val dummyTvshow = Resource.success(DataDummy.generateDetailTvShow())
        val tvShow = MutableLiveData<Resource<TvShowEntity>>()
        tvShow.value = dummyTvshow

        Mockito.`when`(mContentRepository.getDetailTvShow(tvShowId)).thenReturn(tvShow)
        viewModel.setSelectTvShow(tvShowId)
        viewModel.detailTvShow.observeForever(observerTvShow)
        verify(observerTvShow).onChanged(dummyTvshow)
    }

    @Test
    fun testSetFavoriteMovie() {
        val dummyMovie = Resource.success(DataDummy.generateDetailMovie())
        val movie = MutableLiveData<Resource<MovieEntity>>()
        movie.value = dummyMovie

        Mockito.`when`(mContentRepository.getDetailMovie(movieId)).thenReturn(movie)
        viewModel.detailMovie =  mContentRepository.getDetailMovie(movieId)
        viewModel.setFavoriteMovie()
        verify(mContentRepository).setFavoriteMovie(movie.value?.data as MovieEntity, true)
        verifyNoMoreInteractions(observerMovie)
    }

    @Test
    fun setFavoriteTvShow() {
        val dummyTvshow = Resource.success(DataDummy.generateDetailTvShow())
        val tvShow = MutableLiveData<Resource<TvShowEntity>>()
        tvShow.value = dummyTvshow

        Mockito.`when`(mContentRepository.getDetailTvShow(tvShowId)).thenReturn(tvShow)
        viewModel.detailTvShow = mContentRepository.getDetailTvShow(tvShowId)
        viewModel.setFavoriteTvShow()
        verify(mContentRepository).setFavoriteTvShow(tvShow.value?.data as TvShowEntity, true)
        verifyNoMoreInteractions(observerTvShow)
    }
}