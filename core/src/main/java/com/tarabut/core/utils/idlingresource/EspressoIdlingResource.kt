package com.tarabut.core.utils.idlingresource

import com.tarabut.core.BuildConfig


/**
 * Espresso idling resource which is exposing all the functionalities required
 * for managing application idle states
 * Created by Lajesh Dineshkumar
 */
object EspressoIdlingResource {
    private const val RESOURCE = "GLOBAL"

    private val countingIdlingResource = CountingIdlingResource(RESOURCE)

    /**
     * This method needs to be called before starting any long running process in the app.
     * If the counter is greater than zero, then espresso tests will wait until the app is in idle state
     * */
    fun increment(){
        if(BuildConfig.DEBUG)
            countingIdlingResource.increment()
    }

    /**
     * This method needs to be called after finishing the long running operation.
     * now that the data has been loaded, we can mark the app as idle
     * first, make sure the app is still marked as busy then decrement, there might be cases
     * when other components finished their asynchronous tasks and marked the app as idle
     */
    fun decrement(){
        if(BuildConfig.DEBUG && !getIdlingResource().isIdleNow) {
            countingIdlingResource.decrement()
        }

    }

    fun getIdlingResource() : CountingIdlingResource {
        return countingIdlingResource
    }
}