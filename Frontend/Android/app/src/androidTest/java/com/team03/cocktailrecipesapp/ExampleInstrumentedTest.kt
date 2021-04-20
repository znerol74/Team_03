package com.team03.cocktailrecipesapp

import android.widget.EditText
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.team03.cocktailrecipesapp", appContext.packageName)
    }

    @Test
    fun loginDataTest(){
        onView(withId(R.id.username)).perform(typeText("Testusername"), closeSoftKeyboard())
        onView(withId(R.id.password)).perform(typeText("Testpassword"), closeSoftKeyboard())
    }

    @Test
    fun loginButton() {
        onView(withId(R.id.loginbtn)).perform(click())
    }

    @Test
    fun registerButton() {
        onView(withId(R.id.registerbtn)).perform(click())
    }
}