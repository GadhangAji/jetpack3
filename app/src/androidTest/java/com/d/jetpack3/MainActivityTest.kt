package com.d.jetpack3

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import com.d.jetpack3.data.network.EspressoIdlingResource
import org.junit.*
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

class MainActivityTest {

    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoTestIdlingResource)
    }
    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @Test
    fun test1LoadMovieAndTvShow() {
        Espresso.onView(withId(R.id.rv_movie))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rv_movie))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(5))

        Espresso.onView(withId(R.id.navigation_tvshow)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_tv_show))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rv_tv_show))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(5))

        Espresso.onView(withId(R.id.navigation_movie)).perform(ViewActions.click())
    }

    @Test
    fun test2ViewTest() {
        Espresso.onView(withId(R.id.rv_movie))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(withId(R.id.navigation_tvshow)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_tv_show))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(withId(R.id.tab_fav)).perform(ViewActions.click())
        Espresso.onView(withText(R.string.movie)).perform(ViewActions.click())
        Espresso.onView(withText(R.string.tvShow)).perform(ViewActions.click())

        Espresso.onView(withId(R.id.navigation_movie)).perform(ViewActions.click())
    }

    @Test
    fun test3InsertAndUpdateFavorite() {
        Espresso.onView(withId(R.id.rv_movie))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(3,
                ViewActions.click()
            ))
        Espresso.onView(withId(R.id.fab_favorite)).perform(ViewActions.click())
        Espresso.pressBack()

        Espresso.onView(withId(R.id.navigation_tvshow)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_tv_show))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rv_tv_show)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(3,
                ViewActions.click()
            ))
        Espresso.onView(withId(R.id.fab_favorite)).perform(ViewActions.click())
        Espresso.pressBack()

        Espresso.onView(withId(R.id.tab_fav)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_fav_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
                ViewActions.click()
            ))
        Espresso.onView(withId(R.id.fab_favorite)).perform(ViewActions.click())
        Espresso.pressBack()

        Espresso.onView(withId(R.id.tab_fav)).perform(ViewActions.click())
        Espresso.onView(withText(R.string.tvShow)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_fav_tv_show)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
                ViewActions.click()
            ))
        Espresso.onView(withId(R.id.fab_favorite)).perform(ViewActions.click())
        Espresso.pressBack()
    }

    @Test
    fun test4DetailMovie() {
        Espresso.onView(withId(R.id.rv_movie))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rv_movie))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(2))
        Espresso.onView(withId(R.id.rv_movie))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(2,
                    ViewActions.click()
                ))
        Espresso.onView(withId(R.id.image_poster))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.text_title))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.text_desc))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.pressBack()
    }

    @Test
    fun test5DetailTvShow() {
        Espresso.onView(withId(R.id.navigation_tvshow)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_tv_show))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rv_tv_show))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(2))
        Espresso.onView(withId(R.id.rv_tv_show))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(2,
                    ViewActions.click()
                ))

        Espresso.onView(withId(R.id.image_poster))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.text_title))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.text_desc))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.pressBack()
    }
}