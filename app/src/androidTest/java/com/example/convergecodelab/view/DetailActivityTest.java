package com.example.convergecodelab.view;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.convergecodelab.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.os.SystemClock.sleep;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.isDialog;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class DetailActivityTest {
    @Rule
    public ActivityTestRule<DetailActivity>  detailActivityActivityTestRule =
            new ActivityTestRule<>(DetailActivity.class);

    @Before
    public void setUp(){
        Intent intent = new Intent();
        intent.putExtra("username", "TheDancerCodes");
        intent.putExtra("imageUrl", "https://avatars0.githubusercontent.com/u/6739804?v=4");
        detailActivityActivityTestRule.launchActivity(intent);
        sleep(100);
    }

    @Test
    public void progressDialog_isDisplayed() {
        onView(withText("Loading TheDancerCodes Info..."))
                .inRoot(isDialog())
                .check(matches(isDisplayed()));
        sleep(3000);
    }

    @Test
    public void detailActivityLayout_isRedered(){
        sleep(3000);
        onView(withId(R.id.user_details)).check(matches(isDisplayed()));
    }

    @Test
    public void userProfileInformation_isDisplayed(){
        sleep(3000);
        onView(withText("TheDancerCodes")).check(matches(isDisplayed()));
        onView(withText("Bio")).check(matches(isDisplayed()));
        onView(withText("Followers")).check(matches(isDisplayed()));
        onView(withText("Following")).check(matches(isDisplayed()));
        onView(withText("Repositories")).check(matches(isDisplayed()));
        onView(withText("Gists")).check(matches(isDisplayed()));
        onView(withId(R.id.userProfile)).check(matches(isDisplayed()));
        onView(withId(R.id.userCreate_date)).check(matches(isDisplayed()));
        onView(withId(R.id.organization)).check(matches(isDisplayed()));
        onView(withId(R.id.userOrgs)).check(matches(isDisplayed()));
        onView(withId(R.id.userFollowers)).check(matches(isDisplayed()));
        onView(withId(R.id.userFollowing)).check(matches(isDisplayed()));
        onView(withId(R.id.userRepositories)).check(matches(isDisplayed()));
        onView(withId(R.id.userGists)).check(matches(isDisplayed()));
        onView(withId(R.id.userBioInformation)).check(matches(isDisplayed()));
    }
}