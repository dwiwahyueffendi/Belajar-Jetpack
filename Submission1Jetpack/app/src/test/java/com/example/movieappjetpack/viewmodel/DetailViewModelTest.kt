package com.example.movieappjetpack.viewmodel

import com.example.movieappjetpack.data.dummy.DataDummy
import junit.framework.TestCase
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class DetailViewModelTest : TestCase() {
    private lateinit var detailViewModel: DetailViewModel
    private val dummyMovie = DataDummy.generateDummyMovie()[0]
    private val idMovie = dummyMovie.id
    private val dummyTvShow = DataDummy.generateDummyTvShow()[0]
    private val idTvShow = dummyTvShow.id


    @Before
    override fun setUp() {
        detailViewModel = DetailViewModel()
    }

    @Test
    fun testSetContentDetail() {
        detailViewModel.setContentDetail(idMovie)
        detailViewModel.setContentDetail(idTvShow)
    }

    @Test
    fun testGetContentDetail() {
        //Testing Detail Movie
        detailViewModel.setContentDetail(dummyMovie.id)
        val contentMovie = detailViewModel.getContentDetail()
        Assert.assertNotNull(contentMovie)
        junit.framework.Assert.assertEquals(dummyMovie.id, contentMovie.id)
        junit.framework.Assert.assertEquals(dummyMovie.title, contentMovie.title)
        junit.framework.Assert.assertEquals(dummyMovie.description, contentMovie.description)
        junit.framework.Assert.assertEquals(dummyMovie.dateRelease, contentMovie.dateRelease)
        junit.framework.Assert.assertEquals(dummyMovie.image, contentMovie.image)
        junit.framework.Assert.assertEquals(dummyMovie.vote, contentMovie.vote)
        junit.framework.Assert.assertEquals(dummyMovie.popularity, contentMovie.popularity)
        junit.framework.Assert.assertEquals(dummyMovie.link, contentMovie.link)

        //Testing Detail TvShow
        detailViewModel.setContentDetail(dummyTvShow.id)
        val contentTvShow = detailViewModel.getContentDetail()
        Assert.assertNotNull(contentTvShow)
        junit.framework.Assert.assertEquals(dummyTvShow.id, contentTvShow.id)
        junit.framework.Assert.assertEquals(dummyTvShow.title, contentTvShow.title)
        junit.framework.Assert.assertEquals(dummyTvShow.description, contentTvShow.description)
        junit.framework.Assert.assertEquals(dummyTvShow.dateRelease, contentTvShow.dateRelease)
        junit.framework.Assert.assertEquals(dummyTvShow.image, contentTvShow.image)
        junit.framework.Assert.assertEquals(dummyTvShow.vote, contentTvShow.vote)
        junit.framework.Assert.assertEquals(dummyTvShow.popularity, contentTvShow.popularity)
        junit.framework.Assert.assertEquals(dummyTvShow.link, contentTvShow.link)
    }
}