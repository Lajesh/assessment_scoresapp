package com.tarabut.data.di

import com.tarabut.data.repository.ScoresRepositoryImpl
import com.tarabut.domain.repository.IScoresRepository
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

/****
 * DI module which provides the factory repository instances
 * Author: Lajesh Dineshkumar
 *****/
object RepositoryModule {
    fun load() {
        loadKoinModules(repositoryModules)
    }

    val repositoryModules = module {
        factory<IScoresRepository>{ ScoresRepositoryImpl(scoresApi = get()) }
    }
}