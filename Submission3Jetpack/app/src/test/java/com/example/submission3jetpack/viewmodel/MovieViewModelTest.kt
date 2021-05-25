package com.example.submission3jetpack.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.example.submission3jetpack.data.source.ContentRepository
import com.example.submission3jetpack.data.source.local.entity.MovieEntity
import com.example.submission3jetpack.vo.Resource
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var mContentRepository: ContentRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<MovieEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>

    @Before
    fun setup() {
        viewModel = MovieViewModel(mContentRepository)
    }

    @Test
    fun testGetMovies() {
        val dummyMovies = Resource.success(pagedList)
        Mockito.`when`(dummyMovies.data?.size).thenReturn(6)

        val movies = MutableLiveData<Resource<PagedList<MovieEntity>>>()
        movies.value = dummyMovies
        Mockito.`when`(mContentRepository.getMovies()).thenReturn(movies)

        val movie = viewModel.getMovies().value?.data
        Mockito.verify(mContentRepository).getMovies()
        Assert.assertNotNull(movie)
        Assert.assertEquals(6, movie?.size)

        viewModel.getMovies().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyMovies)
    }
}