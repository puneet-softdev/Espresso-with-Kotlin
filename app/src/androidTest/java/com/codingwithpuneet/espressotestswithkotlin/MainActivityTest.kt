package com.codingwithpuneet.espressotestswithkotlin

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest{

    // -- Activity Launch, View Display and Click Test --
    @Test
    fun appLaunchesSuccessfully(){
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun onLaunchFabButtonDisplayed(){
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.fab))
            .check(matches(isDisplayed()))
    }

    @Test
    fun onLaunchClickSetAlarm(){
        ActivityScenario.launch(MainActivity::class.java)
        onView(withText("SET ALARM"))
            .perform(click())
    }

    // -- Combined Test --

    @Test
    fun onLaunchClickFabButtonTypeAWord(){
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.fab))
            .perform(click())

        onView(withId(R.id.edit_word))
            .perform(
                typeText("Hey I am Puneet!. I am typing with Espresso UI Automated, Can you see that?"),
                ViewActions.closeSoftKeyboard()
            )

        onView(withId(R.id.button_save))
            .perform(click())
    }

    //  -- Menus Tests --

    @Test
    fun onLaunchSettingsBtnDisplayed(){
        ActivityScenario.launch(MainActivity::class.java)
        onView(withText("Search"))
            .check(matches(isDisplayed()))
    }

    @Test
    fun onLaunchOpenMenuOverflowButton(){
        ActivityScenario.launch(MainActivity::class.java)
        openActionBarOverflowOrOptionsMenu(ApplicationProvider.getApplicationContext<Context>())
    }

    // -- RecyclerView Tests --

    @Test
    fun findItemWithTextInRecyclerView(){
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.rvFlowers))
            .perform(
                RecyclerViewActions.scrollTo<RecyclerView.ViewHolder>(
                    hasDescendant(withText("Oreo"))
                )
            )
    }

    @Test
    fun clickItemWithPosition(){
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.rvFlowers))
            .perform(RecyclerViewActions.actionOnItem<RecyclerView.ViewHolder>(
                hasDescendant(withText("Oreo")),
                click()))
    }
}