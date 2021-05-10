package com.example.myapplication.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.myapplication.data.ContentCatalogRepository
import com.example.myapplication.data.local.ContentEntity
import com.example.myapplication.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import junit.framework.TestCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest : TestCase(){

    private lateinit var detailViewModel: DetailViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var contentCatalogRepository: ContentCatalogRepository

    @Mock
    private lateinit var observer: Observer<ContentEntity>

    @Before
    fun SetUp(){
        detailViewModel = DetailViewModel(contentCatalogRepository)
    }

    @Test
    fun testGetMovieDetail() {
        val movieEntity = MutableLiveData<ContentEntity>()
        val dummyMovie = DataDummy.generateDataMovieDummy()[0]
        movieEntity.value = dummyMovie
        
        val movieId = dummyMovie.id
        Mockito.`when`(contentCatalogRepository.getMovieDetail(movieId)).thenReturn(movieEntity)

        val dataMovie = detailViewModel.getMovieDetail(movieId).value as ContentEntity

        assertNotNull(dataMovie)
        assertEquals(dummyMovie.backdropPath, dataMovie.backdropPath)
        assertEquals(dummyMovie.id, dataMovie.id)
        assertEquals(dummyMovie.desc, dataMovie.desc)
        assertEquals(dummyMovie.posterPath, dataMovie.posterPath)
        assertEquals(dummyMovie.releaseDate, dataMovie.releaseDate)
        assertEquals(dummyMovie.title, dataMovie.title)
        assertEquals(dummyMovie.voteAverage, dataMovie.voteAverage)

        detailViewModel.getMovieDetail(movieId).observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }
    @Test
    fun testGetTvShowDetail() {
        val tvShowEntity = MutableLiveData<ContentEntity>()
        val dummyTvShow = DataDummy.generateDataTvShowDummy()[0]
        tvShowEntity.value = dummyTvShow

        val TvShowId = dummyTvShow.id
        Mockito.`when`(contentCatalogRepository.getTvShowDetail(TvShowId)).thenReturn(tvShowEntity)

        val dataTvShow = detailViewModel.getTvShowDetail(TvShowId).value as ContentEntity

        assertNotNull(dataTvShow)
        assertEquals(dummyTvShow.backdropPath, dataTvShow.backdropPath)
        assertEquals(dummyTvShow.id, dataTvShow.id)
        assertEquals(dummyTvShow.desc, dataTvShow.desc)
        assertEquals(dummyTvShow.posterPath, dataTvShow.posterPath)
        assertEquals(dummyTvShow.releaseDate, dataTvShow.releaseDate)
        assertEquals(dummyTvShow.title, dataTvShow.title)
        assertEquals(dummyTvShow.voteAverage, dataTvShow.voteAverage)

        detailViewModel.getTvShowDetail(TvShowId).observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }
}