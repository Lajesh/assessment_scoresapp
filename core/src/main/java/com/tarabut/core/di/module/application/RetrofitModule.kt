package com.tarabut.core.di.module.application

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.tarabut.core.config.Configuration
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/****
 * Retrofit Module
 * Author: Lajesh Dineshkumar
 *****/
object RetrofitModule {
    fun load() {
        loadKoinModules(retrofitModules)
    }

    private val retrofitModules = module {
        single {
            Retrofit.Builder()
                .client(get())
                .addConverterFactory(getGsonConverterFactory())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).baseUrl(get<String>())
                .build() as Retrofit
        }

        single {
            Configuration.baseURL
        }
    }

    private fun getGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create(getGson())
    }

    private fun getGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setDateFormat("d MMM yyyy HH:mm")
        return gsonBuilder.create()
    }
}