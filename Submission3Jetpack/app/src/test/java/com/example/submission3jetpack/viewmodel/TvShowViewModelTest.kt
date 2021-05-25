package com.example.submission3jetpack.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.example.submission3jetpack.data.source.ContentRepository
import com.example.submission3jetpack.data.source.local.entity.TvShowEntity
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
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var mContentRepository: ContentRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<TvShowEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<TvShowEntity>

    @Before
    fun setup() {
        viewModel = TvShowViewModel(mContentRepository)
    }

    @Test
    fun testGetTvShows() {
        val dummyTvShows = Resource.success(pagedList)
        Mockito.`when`(dummyTvShows.data?.size).thenReturn(6)

        val tvShows = MutableLiveData<Resource<PagedList<TvShowEntity>>>()
        tvShows.value = dummyTvShows
        Mockito.`when`(mContentRepository.getTvShows()).thenReturn(tvShows)

        val tvShow = viewModel.getTvShows().value?.data
        Mockito.verify(mContentRepository).getTvShows()
        Assert.assertNotNull(tvShow)
        Assert.assertEquals(6, tvShow?.size)

        viewModel.getTvShows().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyTvShows)
    }
}