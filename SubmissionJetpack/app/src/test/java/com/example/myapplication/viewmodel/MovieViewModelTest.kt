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
class MovieViewModelTest {

    private lateinit var movieViewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var contentCatalogRepository: ContentCatalogRepository

    @Mock
    private lateinit var observer: Observer<List<ContentEntity>>

    @Before
    fun setUp(){
        movieViewModel = MovieViewModel(contentCatalogRepository)
    }

    @Test
    fun testGetPlayingMovie() {
        val listMovie = MutableLiveData<List<ContentEntity>>()
        val dummyMovie = DataDummy.generateDataMovieDummy()
        listMovie.value = dummyMovie

        Mockito.`when`(contentCatalogRepository.getPlayingMovies()).thenReturn(listMovie)
        val movie = movieViewModel.getListMovies().value
        verify(contentCatalogRepository).getPlayingMovies()
        TestCase.assertNotNull(movie)
        TestCase.assertEquals(10, movie?.size)

        movieViewModel.getListMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }
}