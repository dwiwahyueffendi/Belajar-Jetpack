package com.example.submission3jetpack.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.*
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.submission3jetpack.R
import com.example.submission3jetpack.utils.DataDummy
import com.example.submission3jetpack.utils.EspressoIdlingResource
import com.google.android.material.tabs.TabLayout
import org.hamcrest.Matchers
import org.junit.After
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(AndroidJUnit4::class)
class HomeActivityTest{

    private val dummyMovies = DataDummy.generateDummyMovies()
    private val dummyTvShows = DataDummy.generateDummyTvShows()

    @Before
    fun setup() {
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource())
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister((EspressoIdlingResource.getEspressoIdlingResource()))
    }

    @Test
    fun test1LoadMovies() {
        Espresso.onView(withId(R.id.navigation_movies)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_movies)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(10))
    }

    @Test
    fun test2LoadDetailMovie() {
        Espresso.onView(withId(R.id.navigation_movies)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_movies)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))
        Espresso.onView(withId(R.id.iv_backdrop_detail)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.iv_poster)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_title)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_rating)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_release)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_description_title)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_description)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.favorite)).perform(ViewActions.click())
        Espresso.pressBack()
    }

    @Test
    fun test3LoadTvShows() {
        Espresso.onView(withId(R.id.navigation_tvShow)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_tv_shows)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rv_tv_shows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(10))
    }

    @Test
    fun test4LoadDetailTvShow() {
        Espresso.onView(withId(R.id.navigation_tvShow)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_tv_shows)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rv_tv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))
        Espresso.onView(withId(R.id.iv_backdrop_detail)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.iv_poster)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_title)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_rating)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_release)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_description_title)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_description)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.favorite)).perform(ViewActions.click())
        Espresso.pressBack()
    }

    @Test
    fun test5LoadFavoriteMovies() {
        Espresso.onView(withId(R.id.navigation_favorites)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.tabs)).perform(selectTabAtPosition(0))
        Espresso.onView(withId(R.id.rv_favorite_movies)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rv_favorite_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
    }

    @Test
    fun test6LoadDetailFavoriteMovie() {
        Espresso.onView(withId(R.id.navigation_favorites)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.tabs)).perform(selectTabAtPosition(0))
        Espresso.onView(withId(R.id.rv_favorite_movies)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rv_favorite_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))
        Espresso.onView(withId(R.id.iv_backdrop_detail)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.iv_poster)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_title)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_rating)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_release)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_description_title)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_description)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.favorite)).perform(ViewActions.click())
    }

    @Test
    fun test7LoadFavoriteTvShows() {
        Espresso.onView(withId(R.id.navigation_favorites)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.tabs)).perform(selectTabAtPosition(1))
        Espresso.onView(withId(R.id.rv_favorite_tv_shows)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rv_favorite_tv_shows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShows.size))
    }

    @Test
    fun test8LoadDetailFavoriteTvShow() {
        Espresso.onView(withId(R.id.navigation_favorites)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.tabs)).perform(selectTabAtPosition(1))
        Espresso.onView(withId(R.id.tabs)).perform(ViewActions.swipeRight())
        Espresso.onView(withId(R.id.rv_favorite_tv_shows)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rv_favorite_tv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))
        Espresso.onView(withId(R.id.iv_backdrop_detail)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.iv_poster)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_title)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_rating)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_release)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_description_title)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_description)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.favorite)).perform(ViewActions.click())
    }

    private fun selectTabAtPosition(tabIndex: Int): ViewAction {
        return object : ViewAction {
            override fun getDescription() = "with tab at index $tabIndex"

            override fun getConstraints() = Matchers.allOf(
                ViewMatchers.isDisplayed(),
                ViewMatchers.isAssignableFrom(TabLayout::class.java)
            )

            override fun perform(uiController: UiController, view: View) {
                val tabLayout = view as TabLayout
                val tabAtIndex: TabLayout.Tab = tabLayout.getTabAt(tabIndex)
                    ?: throw PerformException.Builder()
                        .withCause(Throwable("No tab at index $tabIndex"))
                        .build()

                tabAtIndex.select()
            }
        }
    }
}