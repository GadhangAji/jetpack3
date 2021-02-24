package com.d.jetpack1.data.detail

import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.d.jetpack1.R
import com.d.jetpack1.data.MovieEntity
import com.d.jetpack1.utils.DataDummy
import com.d.jetpack1.utils.MOVIE_ID
import org.junit.Rule
import org.junit.Test

class DetailActivityTest {
    @Rule
    @JvmField
    var activityRule: ActivityTestRule<DetailActivity> =
        object : ActivityTestRule<DetailActivity>(DetailActivity::class.java) {
            override fun getActivityIntent(): Intent {
                val model = MovieEntity(
                    DataDummy.title_movies[0],
                    DataDummy.img_movie[0],
                    DataDummy.movie_overview[0]
                )

                val targetContext = InstrumentationRegistry.getInstrumentation().targetContext
                val result = Intent(targetContext, DetailActivity::class.java)
                result.putExtra(MOVIE_ID, model)
                return result
            }
        }

    @Test
    fun loadData() {
        Espresso.onView(withId(R.id.text_title))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.text_title))
            .check(ViewAssertions.matches(withText(DataDummy.title_movies[0])))
        Espresso.onView(withId(R.id.image_poster))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.text_desc))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.text_desc))
            .check(ViewAssertions.matches(withText(DataDummy.movie_overview[0])))
    }
}