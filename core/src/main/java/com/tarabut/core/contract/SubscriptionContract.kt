package com.tarabut.core.contract

/****
 * Subscription contract. Wherever you want to subcribe for the network response
 * or navigation event, implement this interface
 * Author: Lajesh Dineshkumar
 *****/
interface SubscriptionContract {
    fun subscribeNetworkResponse() {
        // Implementation goes in the owner
    }
    fun subscribeNavigationEvent() {
        // Implementation goes in the owner
    }
}
