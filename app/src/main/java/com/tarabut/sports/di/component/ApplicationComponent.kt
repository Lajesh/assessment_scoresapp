package com.tarabut.sports.di.component

import com.tarabut.sports.di.module.DbModule
import com.tarabut.sports.di.module.ViewModelModule
import com.tarabut.core.di.module.application.RetrofitModule
import com.tarabut.core.di.module.application.ApiModule
import com.tarabut.core.di.module.application.ApplicationModule
import com.tarabut.core.di.module.application.OkhttpModule
import com.tarabut.data.di.RepositoryModule
import com.tarabut.domain.di.UseCaseModule
import com.tarabut.scores.di.ScoresViewModelModule

/****
 * Application component which loads all the Koin Modules
 * Author: Lajesh Dineshkumar
 *****/
object ApplicationComponent {
    fun loadAllModules(){
        RetrofitModule.load()
        OkhttpModule.load()
        RepositoryModule.load()
        UseCaseModule.load()
        ApiModule.load()
        ApplicationModule.load()
        ViewModelModule.load()
        ScoresViewModelModule.load()
        DbModule.load()

    }
}