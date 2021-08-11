package com.tarabut.analyticslib

import android.app.Activity

/****
 * Abstraction of Analytics
 * Author: Lajesh Dineshkumar
 *****/
interface AnalyicsHelper {
    fun sendScreenView(screenName: String, activity: Activity)
    fun logUiEvent(itemId: String, action: String)
    fun setUserSignedIn(isSignedIn: Boolean)
    fun setUserRegistered(isRegistered: Boolean)
}