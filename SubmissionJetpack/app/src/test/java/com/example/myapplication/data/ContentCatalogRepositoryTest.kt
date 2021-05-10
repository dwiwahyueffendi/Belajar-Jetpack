package com.example.myapplication.liveData

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.myapplication.data.FakeContentCatalogRepository
import com.example.myapplication.data.remote.RemoteDataSource
import com.example.myapplication.utils.DataDummy
import com.example.myapplication.utils.LiveDataTestUtils
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class ContentCatalogRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testing = Mockito.mock(RemoteDataSource::class.java)
    private val fakeCatalogContentRepository = FakeContentCatalogRepository(testing)

    private val listMovie = DataDummy.GenerateDataMovie()
    private val listTvShow = DataDummy.GenerateDataTvShow()
    private val movieId = listMovie[0].id
    private val tvShowId = listTvShow[0].id

    @Test
    fun testGetPlayingMovies() {
        
        runBlocking { doAnswer { loadData ->
            (loadData.arguments[0] as RemoteDataSource.LoadPlayingMovie).onAllMovies(listMovie) 
            null }.`when`(testing).getPlayingMovies(any())
        }
        
        val liveData = LiveDataTestUtils.getValue(fakeCatalogContentRepository.getPlayingMovies())
        runBlocking {
            verify(testing).getPlayingMovies(any())
        }
        
        assertNotNull(liveData)
        assertEquals(listMovie.size.toLong(), liveData.size.toLong())
    }

    @Test
    fun testGetMovieDetail() {
        val movieResponse = DataDummy.GenerateDataMovie()[0]
        runBlocking { doAnswer { loadData ->
            (loadData.arguments[1] as RemoteDataSource.LoadMovieDetail).onMovieDetail(movieResponse)
            null }.`when`(testing).getMovieDetail(eq(movieId), any())
        }
        
        val liveData = LiveDataTestUtils.getValue(fakeCatalogContentRepository.getMovieDetail(movieId))
        runBlocking {
            verify(testing).getMovieDetail(eq(movieId), any())
        }
        
        assertNotNull(liveData)
        assertEquals(movieResponse.id, liveData.id)
    }

    @Test
    fun testGetPlayingTvShow() {
        runBlocking { doAnswer { loadData ->
            (loadData.arguments[0] as RemoteDataSource.LoadPlayingTvShow).onAllTvShow(listTvShow)
            null }.`when`(testing).getPlayingTvShow(any())
        }
        
        val liveData = LiveDataTestUtils.getValue(fakeCatalogContentRepository.getPlayingTvShow())
        runBlocking {
            verify(testing).getPlayingTvShow(any())
        }
        
        assertNotNull(liveData)
        assertEquals(listTvShow.size.toLong(), liveData.size.toLong())
    }

    @Test
    fun testGetTvShowDetail() {
        val tvShowResponse = DataDummy.GenerateDataTvShow()[0]
        runBlocking { doAnswer { loadData ->
            (loadData.arguments[1] as RemoteDataSource.LoadTvShowDetail).onTvShowDetail(tvShowResponse)
            null }.`when`(testing).getTvShowDetail(eq(tvShowId), any())
        }
        
        val liveData = LiveDataTestUtils.getValue(fakeCatalogContentRepository.getTvShowDetail(tvShowId))
        runBlocking {
            verify(testing).getTvShowDetail(eq(tvShowId), any())
        }
        
        assertNotNull(liveData)
        assertEquals(tvShowResponse.id, liveData.id)
    }
}