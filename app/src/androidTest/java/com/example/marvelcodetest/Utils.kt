package com.example.marvelcodetest

import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers

private const val TIMEOUT = 10000L
private const val CONDITION_CHECK_INTERVAL = 100L

fun waitLoading() {
    waitForViewIsHide(R.id.progressBar)
}

fun waitForViewIsHide(id: Int) {
    val startTime = System.currentTimeMillis()
    do {
        try {
            Espresso.onView(ViewMatchers.withId(id))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            Thread.sleep(CONDITION_CHECK_INTERVAL)
        } catch (e: Exception) {
            return
        } catch (e: Error) {
            return
        }
    } while (System.currentTimeMillis() - startTime <= TIMEOUT)
}

fun ViewInteraction.checkIsVisible(): ViewInteraction = check(getViewAssertion(ViewMatchers.Visibility.VISIBLE))

fun ViewInteraction.isGone() = getViewAssertion(ViewMatchers.Visibility.GONE)

private fun getViewAssertion(visibility: ViewMatchers.Visibility): ViewAssertion? {
    return ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(visibility))
}