package com.tarabut.core.listeners

/**
 * Back press listener for handling back navigation in activity/fragments
 * Author: Lajesh Dineshkumar
 */
interface BackPressListener {
    fun onBackPress(): Boolean
}