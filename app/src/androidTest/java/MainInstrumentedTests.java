/**
 * Created by samhalperin on 1/28/18.
 */

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.samhalperin.cooperhewitt.R;
import com.samhalperin.cooperhewitt.masterscreen.MasterActivity;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.core.deps.guava.base.Predicates.instanceOf;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.allOf;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainInstrumentedTests {

    @Rule
    public ActivityTestRule<MasterActivity> mMasterActivityTestRule =
            new ActivityTestRule<MasterActivity>(MasterActivity.class);

    @Test
    public void testShowAboutScreen() throws Exception {
        onView(withId(R.id.action_about)).perform(click());
        onView(withId(R.id.about)).check(matches(isDisplayed()));
    }

    @Test
    public void testRvClickNavigatesToDetailScreen() throws Exception {
        onView(withId(R.id.rv))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));
        onView(withId(R.id.detail_view)).check(matches(isDisplayed()));
    }


    //third test that is currently beyond my espresso fu.
    //select Neoclassical from period selector (this should have 400 artifacts)
    // verify rv adapter has less than CooperHewittApp.nPerPage items
    //scroll rv to bottom
    // verify rv adapter has more than CooperHewittApp.nPerPage items

}
