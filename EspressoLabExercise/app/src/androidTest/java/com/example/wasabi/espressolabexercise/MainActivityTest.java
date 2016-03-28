package com.example.wasabi.espressolabexercise;

import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withInputType;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Wasabi on 3/28/2016.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule
            = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void testIfEverythingIsDisplayed() throws Exception {
        onView(withId(R.id.editText)).check(matches(isDisplayed()));
        onView(withId(R.id.balance_textView)).check(matches(isDisplayed()));
        onView(withId(R.id.add_button)).check(matches(isDisplayed()));
        onView(withId(R.id.decrease_button)).check(matches(isDisplayed()));
        onView(withId(R.id.account_info_button)).check(matches(isDisplayed()));
    }


    @Test
    public void testIfDecreaseButtonWorks() throws Exception {
        onView(withId(R.id.editText)).perform(typeText("1"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.decrease_button)).perform(click());
        onView(withId(R.id.balance_textView)).check(matches(withText("$-1.0")));
        onView(withId(R.id.editText)).perform(clearText());

        onView(withId(R.id.editText)).perform(typeText("0.4"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.decrease_button)).perform(click());
        onView(withId(R.id.balance_textView)).check(matches(withText("$-1.4")));
        onView(withId(R.id.editText)).perform(clearText());
    }

    @Test
    public void testIfAddButtonWorks() throws Exception {
        onView(withId(R.id.editText)).perform(typeText("3"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.add_button)).perform(click());
        onView(withId(R.id.balance_textView)).check(matches(withText("$3.0")));
        onView(withId(R.id.editText)).perform(clearText());

        onView(withId(R.id.editText)).perform(typeText("1.2"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.add_button)).perform(click());
        onView(withId(R.id.balance_textView)).check(matches(withText("$4.2")));
        onView(withId(R.id.editText)).perform(clearText());

    }


    @Test
    public void testIfInformationIsVisible() throws Exception {
        onView(withId(R.id.account_info_button)).perform(click());
        onView(withId(R.id.username_textView)).check(matches(isDisplayed()));
        onView(withId(R.id.email_textView)).check(matches(isDisplayed()));
    }
}
