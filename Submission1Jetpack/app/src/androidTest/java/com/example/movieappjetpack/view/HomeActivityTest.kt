package com.example.movieappjetpack.view

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.movieappjetpack.R
import com.example.movieappjetpack.data.dummy.DataDummy
import org.junit.Rule
import org.junit.Test

class HomeActivityTest{
    private val dummyMovie = DataDummy.generateDummyMovie()
    private val dummyTvShow = DataDummy.generateDummyTvShow()

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun loadMovies(){
        onView(withText("MOVIE")).perform(click())
        onView(withId(R.id.rv_list_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_list_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadDetailMovies(){
        //RecyclerView List Content
        onView(withText("MOVIE")).perform(click())
        onView(withId(R.id.rv_list_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_list_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        //Image
        onView(withId(R.id.iv_content_detail)).check(matches(isDisplayed()))
        //Title
        onView(withId(R.id.tv_title_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title_detail)).check(matches(withText(dummyMovie[0].title)))
        //Date Release
        onView(withId(R.id.tv_date_release)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_date_release)).check(matches(withText("Date Release : ${dummyMovie[0].dateRelease}")))
        //Rating
        onView(withId(R.id.tv_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_rating)).check(matches(withText("Rating : ${dummyMovie[0].vote}")))
        //Popularity
        onView(withId(R.id.tv_popularity)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_popularity)).check(matches(withText("Viewers : ${dummyMovie[0].popularity}")))
        //Description
        onView(withId(R.id.tv_description)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_description)).check(matches(withText("Description :\n${dummyMovie[0].description}")))
    }

    @Test
    fun loadTvShow(){
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.rv_list_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_list_tv_show)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
    }

    @Test
    fun loadDetailTvShow(){
        //RecyclerView List Content
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.rv_list_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_list_tv_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        //Image
        onView(withId(R.id.iv_content_detail)).check(matches(isDisplayed()))
        //Title
        onView(withId(R.id.tv_title_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title_detail)).check(matches(withText(dummyTvShow[0].title)))
        //Date Release
        onView(withId(R.id.tv_date_release)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_date_release)).check(matches(withText("Date Release : ${dummyTvShow[0].dateRelease}")))
        //Description
        onView(withId(R.id.tv_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_rating)).check(matches(withText("Rating : ${dummyTvShow[0].vote}")))
        //Date Release
        onView(withId(R.id.tv_popularity)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_popularity)).check(matches(withText("Viewers : ${dummyTvShow[0].popularity}")))
        //Description
        onView(withId(R.id.tv_description)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_description)).check(matches(withText("Description :\n${dummyTvShow[0].description}")))
    }
}