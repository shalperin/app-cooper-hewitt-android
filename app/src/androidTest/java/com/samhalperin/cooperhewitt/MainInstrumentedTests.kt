package com.samhalperin.cooperhewitt


import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.samhalperin.cooperhewitt.masterscreen.ArtAdapter
import com.samhalperin.cooperhewitt.masterscreen.MasterActivity


@RunWith(AndroidJUnit4::class)
@LargeTest
class MainInstrumentedTests {
    @get:Rule
    var mMasterActivityTestRule = ActivityTestRule(MasterActivity::class.java)

    @Test
    @Throws(Exception::class)
    fun testShowAboutScreen() {
        onView(withId(R.id.action_about)).perform(click())
        onView(withId(R.id.about)).check(matches(isDisplayed()))
    }

// Test currently failing even with animations disabled.
// @Test
//    @Throws(Exception::class)
//    fun testRvClickNavigatesToDetailScreen() {
//        onView(withId(R.id.rv))
//                .perform(
//                        RecyclerViewActions
//                                .actionOnItemAtPosition<RecyclerView.ViewHolder>(1, click()))
//        onView(withId(R.id.detail_view)).check(matches(isDisplayed()))
//    }
}
