package com.tarabut.sports.di

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.tarabut.sports.SportsApp

/**
 * Helper class to automatically inject fragments if they implement [Injectable].
 * Created by Lajesh Dineshkumar
 */
object AppInjector {

    private var resumed = 0
    private var paused = 0

    fun init(sportsApp: SportsApp) {
        sportsApp.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                sportsApp.setLocaleContext(activity)
            }

            override fun onActivityStarted(activity: Activity) {
                // Nothing goes here
            }

            override fun onActivityResumed(activity: Activity) {
                ++resumed
                SportsApp.setAppVisible(true)
            }

            override fun onActivityPaused(activity: Activity) {
                ++paused
            }

            override fun onActivityStopped(activity: Activity) {
                SportsApp.setAppVisible(resumed > paused)
            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
                // Nothing goes here
            }

            override fun onActivityDestroyed(activity: Activity) {
                // Nothing goes here
            }
        })
    }
}
