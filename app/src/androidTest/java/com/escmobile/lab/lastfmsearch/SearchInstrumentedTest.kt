package com.escmobile.lab.lastfmsearch

import android.widget.EditText
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.pressImeActionButton
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.escmobile.lab.lastfmsearch.ui.MainActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Thread.sleep

// TODO: I know this is not ideal, will be replaced with idlingResource (okhttp client)
// so retrofit result is waited before checking the visibility of the view
const val sleepMilli = 4000L

@RunWith(AndroidJUnit4::class)
class SearchInstrumentedTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun before() {
        // TODO register the idlingResource (okhttp client)
    }

    @Test
    fun searchNotFound() {

        onView(isAssignableFrom(EditText::class.java)).perform(
            typeText("xxx no such track xzx"),  // No such track, album or artist
            pressImeActionButton()
        )

        // see TO-DO above
        sleep(sleepMilli)
        onView(withId(R.id.no_results_found)).check(matches(isDisplayed()))
    }

    @Test
    fun searchResultFound() {

        onView(isAssignableFrom(EditText::class.java)).perform(
            typeText("michael"),
            pressImeActionButton()
        )

        // see TO-DO above
        sleep(sleepMilli)
        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()))
    }

    @Test
    fun searchResultFoundAndNoResultViewIsNotDisplayed() {

        onView(isAssignableFrom(EditText::class.java)).perform(
            typeText("michael"),
            pressImeActionButton()
        )

        // see TO-DO above
        sleep(sleepMilli)
        onView(withId(R.id.no_results_found)).check(matches(withEffectiveVisibility(Visibility.GONE)))
    }

    @After
    fun after() {
        // unregister the mighty idlingResource (once it's registered
    }
}
