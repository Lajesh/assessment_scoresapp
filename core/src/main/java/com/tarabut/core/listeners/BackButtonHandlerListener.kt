package com.tarabut.core.listeners

/**
 * Back button handler interface. Add/remove listener functionality
 * Created by Lajesh Dineshkumar
 */
interface BackButtonHandlerListener {
    fun addBackpressListener(listner: BackPressListener)
    fun removeBackpressListener(listner: BackPressListener)
}