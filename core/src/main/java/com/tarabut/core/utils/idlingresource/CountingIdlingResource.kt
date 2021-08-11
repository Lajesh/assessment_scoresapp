package com.tarabut.core.utils.idlingresource

import androidx.test.espresso.IdlingResource
import java.util.concurrent.atomic.AtomicInteger


/**
 * A simple counter implementation of that determines idleness by
 * maintaining an internal counter. When the counter is 0 - it is considered to be idle, when it is
 * non-zero it is not idle. This is very similar to the way a Semaphore
 * behaves.
 * This class can then be used to wrap up operations that while in progress should block tests from
 * accessing the UI.
 * Created by Lajesh Dineshkumar
 */
class CountingIdlingResource constructor(resourceName: String) : IdlingResource {


    private val name: String = resourceName
    private val counter: AtomicInteger = AtomicInteger(0)
    @Volatile
    private var resourceCallback: IdlingResource.ResourceCallback? = null

    override fun getName(): String {
        return name
    }

    override fun isIdleNow(): Boolean {
        return counter.get() == 0
    }

    override fun registerIdleTransitionCallback(callback: IdlingResource.ResourceCallback?) {
        this.resourceCallback = callback
    }

    /**
     * Increments the count of in-flight transactions to the resource being monitored.
     */
    fun increment() {
        counter.getAndIncrement()
    }

    /**
     * Decrements the count of in-flight transactions to the resource being monitored.
     *
     * If this operation results in the counter falling below 0 - an exception is raised.
     *
     * @throws IllegalStateException if the counter is below 0.
     */
    fun decrement() {
        val counterVal = counter.decrementAndGet()
        // we've gone from non-zero to zero. That means we're idle now! Tell espresso.
        if (counterVal == 0 && null != resourceCallback) {
            resourceCallback!!.onTransitionToIdle()
        }

        require(counterVal >= 0) { "Counter has been corrupted!" }
    }

}