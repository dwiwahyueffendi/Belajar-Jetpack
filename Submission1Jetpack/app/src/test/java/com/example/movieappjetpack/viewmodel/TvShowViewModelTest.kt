package com.example.movieappjetpack.viewmodel

import junit.framework.Assert
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test

class TvShowViewModelTest : TestCase() {

    private lateinit var tvShowViewModel: TvShowViewModel

    @Before
    override fun setUp() {
        tvShowViewModel = TvShowViewModel()
    }

    @Test
    fun testGetContentTvShow() {
        //Testing TvShow
        val contentEntity = tvShowViewModel.getContentTvShow()
        Assert.assertNotNull(contentEntity)
        Assert.assertEquals(10, contentEntity.size)
    }
}