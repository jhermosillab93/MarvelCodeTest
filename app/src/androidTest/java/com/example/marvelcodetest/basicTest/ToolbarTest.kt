package com.example.marvelcodetest.basicTest


import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.marvelcodetest.R
import com.example.marvelcodetest.checkIsVisible
import com.example.marvelcodetest.isGone
import com.example.marvelcodetest.ui.main.CharactersMainActivity
import com.example.marvelcodetest.waitLoading
import org.junit.Rule
import org.junit.Test

class ToolbarTest {

    @get : Rule
    var mActivityRule = ActivityScenarioRule(CharactersMainActivity::class.java)


    @Test
    fun test_tool_bar() {
        waitLoading()
        checkToolbarIsInMainMode()
        onView(withId(R.id.charactersRecyclerView)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))
        waitLoading()
        checkToolbarIsInDetailMode()
        onView(withId(R.id.toolbar_left)).perform(ViewActions.click())
        waitLoading()
        checkToolbarIsInMainMode()

    }

    private fun checkToolbarIsInDetailMode() {
        onView(withId(R.id.toolbar_title_image)).isGone()
        onView(withId(R.id.toolbar_left_image)).checkIsVisible()
        onView(withId(R.id.toolbar_left_text)).checkIsVisible()
    }

    private fun checkToolbarIsInMainMode() {
        onView(withId(R.id.toolbar_title_image)).checkIsVisible()
        onView(withId(R.id.toolbar_left_text)).isGone()
        onView(withId(R.id.toolbar_left_image)).isGone()
    }
}