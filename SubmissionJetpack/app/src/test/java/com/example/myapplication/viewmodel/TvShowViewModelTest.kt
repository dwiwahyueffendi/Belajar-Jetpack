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
class TvShowViewModelTest {
    
    private lateinit var tvShowViewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var contentCatalogRepository: ContentCatalogRepository
    @Mock
    private lateinit var observer: Observer<List<ContentEntity>>
    @Before
    fun setUp(){
        tvShowViewModel = TvShowViewModel(contentCatalogRepository)
    }

    @Test
    fun testGetPlayingTvShow() {
        val listTvShow = MutableLiveData<List<ContentEntity>>()
        val dummyTvShow = DataDummy.generateDataTvShowDummy()
        listTvShow.value = dummyTvShow

        Mockito.`when`(contentCatalogRepository.getPlayingTvShow()).thenReturn(listTvShow)
        val tvShow = tvShowViewModel.getListTvShow().value
        verify(contentCatalogRepository).getPlayingTvShow()
        TestCase.assertNotNull(tvShow)
        TestCase.assertEquals(10, tvShow?.size)

        tvShowViewModel.getListTvShow().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }
}