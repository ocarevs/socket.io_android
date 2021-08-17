package com.junga.socketio_android

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.junit.Test
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.filters.LargeTest
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import java.lang.Exception
import java.util.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@LargeTest
class ExampleInstrumentedTest {

    @get:Rule
    val activityRule = activityScenarioRule<EntranceActivity>()

    @Before
    fun setUp() {

    }

    @After
    fun tearDown() {

    }

    @Test(timeout = 1500000L)
    fun goChatGo() {
        onView(withId(R.id.userName)).perform(
            typeText("alice${System.currentTimeMillis()}"),
            closeSoftKeyboard()
        )
        onView(withId(R.id.roomname)).perform(typeText("room1"), closeSoftKeyboard())
        onView(withId(R.id.button)).perform(click())

        for (i in 0..200) {
            runBlocking {
                onView(withId(R.id.editText)).perform(typeText("Hello"), closeSoftKeyboard())
                onView(withId(R.id.send)).perform(click())
                delay(1000)
            }
        }
    }
}
