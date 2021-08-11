package com.tarabut.core.di.module.application

import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

/****
 * App Module which loads all the application wide instances.
 * Author: Lajesh Dineshkumar
 *****/
object ApplicationModule {
    fun load() {
        loadKoinModules(module {

        })
    }
}