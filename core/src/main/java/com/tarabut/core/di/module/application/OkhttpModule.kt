package com.tarabut.core.di.module.application

import com.tarabut.core.config.Configuration
import com.tarabut.core.interceptors.HeaderInterceptor
import okhttp3.OkHttpClient
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import java.net.CookieManager
import java.util.concurrent.TimeUnit

import com.tarabut.core.BuildConfig

/****
 * OKhttp Module
 * Author: Lajesh Dineshkumar
 *****/
object OkhttpModule {
    fun load() {
        loadKoinModules(module {
            single {
                val cookieHandler = CookieManager()
                val okHttpBuilder = OkHttpClient()
                    .newBuilder()
                    .addInterceptor(get<HttpLoggingInterceptor>())
                    .addInterceptor(get<HeaderInterceptor>())
                    .cookieJar(JavaNetCookieJar(cookieHandler))
                    .connectTimeout(Configuration.CONNECT_TIMEOUT, TimeUnit.SECONDS)
                    .callTimeout(Configuration.CALL_TIMEOUT, TimeUnit.SECONDS)
                    .readTimeout(Configuration.READ_TIMEOUT, TimeUnit.SECONDS)

                okHttpBuilder.build()
            }

            single<HeaderInterceptor> {
                HeaderInterceptor()
            }

            single {
                val httpLoggingInterceptor = HttpLoggingInterceptor()
                if (BuildConfig.DEBUG)
                    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                else
                    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.NONE

                httpLoggingInterceptor
            }
        })
    }
}