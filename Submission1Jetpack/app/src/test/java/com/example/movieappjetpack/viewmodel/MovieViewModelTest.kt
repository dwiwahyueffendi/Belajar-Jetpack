package com.example.movieappjetpack.viewmodel

import junit.framework.Assert
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test

class MovieViewModelTest : TestCase() {

    private lateinit var movieViewModel: MovieViewModel

    @Before
    override fun setUp() {
        movieViewModel = MovieViewModel()
    }

    @Test
    fun testGetContentMovie() {
        //Testing Movie
        val contentEntity = movieViewModel.getContentMovie()
        Assert.assertNotNull(contentEntity)
        Assert.assertEquals(10, contentEntity.size)
    }

}