package com.example.convergecodelab.view;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.convergecodelab.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.os.SystemClock.sleep;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.isDialog;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void progressDialog_isDisplayed() {
        onView(withText("Loading Github Users..."))
                .inRoot(isDialog())
                .check(matches(isDisplayed()));
        sleep(3000);
    }

    @Test
    public void mainActivityLayout_isRedered(){
        sleep(3000);
        onView(withId(R.id.main_layout)).check(matches(isDisplayed()));

    }

    @Test
    public void recyclerView_isRedered(){
        sleep(3000);
        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()));
    }

    @Test
    public void swipeToRefreshLayout(){
        sleep(3000);
        onView(withId(R.id.swipeToReflesh)).perform(swipeDown());
    }

    @Test
    public void recyclerView_hasClickableItems(){
        sleep(3000);
        onView(withId(R.id.recycler_view))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        sleep(5000);
        onView(withId(R.id.user_details)).check(matches(isDisplayed()));
    }

}