package com.tarabut.sports

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.tarabut.sports.di.AppInjector
import com.tarabut.sports.di.component.ApplicationComponent.loadAllModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/****
 * Application class
 * Author: Lajesh Dineshkumar
 *****/
@SuppressLint("StaticFieldLeak")
class SportsApp : Application() {

    private var localeContext: Context? = null

    init {
        instance = this
    }

    companion object {
        private lateinit var instance: SportsApp

        private var isAppVisible: Boolean = false

        fun applicationContext(): Context {
            return instance.applicationContext
        }

        fun localeContext(): Context {
            return instance.localeContext ?: instance.applicationContext
        }

        fun getInstance(): SportsApp {
            return instance
        }

        fun setInstance(application: SportsApp) {
            instance = application
        }

        fun isApplicationVisible(): Boolean {
            return isAppVisible
        }

        fun setAppVisible(isVisible: Boolean) {
            isAppVisible = isVisible
        }
    }

    override fun onCreate() {
        super.onCreate()

        AppInjector.init(this)

        startKoin {
            androidContext(this@SportsApp)
        }

        loadAllModules()
    }

    fun setLocaleContext(context: Context) {
        this.localeContext = context
    }
}