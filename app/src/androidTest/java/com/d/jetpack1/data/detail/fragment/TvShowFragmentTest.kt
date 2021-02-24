package com.d.jetpack1.data.detail.fragment

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.d.jetpack1.R
import com.d.jetpack1.RecyclerViewCount
import com.d.jetpack1.utils.FragmentTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TvShowFragmentTest {
    @Rule
    @JvmField
    var activityRule = ActivityTestRule(FragmentTest::class.java)
    private val tvshowFragment = TvShowFragment()

    @Before
    fun setUp() {
        activityRule.activity.setFragment(tvshowFragment)
    }

    @Test
    fun loadTvShow() {
        onView(withId(R.id.rv_tv_show))
            .check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).check(RecyclerViewCount(10))
    }

    @Test
    fun clickTvShow() {
        onView(withId(R.id.rv_tv_show))
            .check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
    }
}