package com.tarabut.domain.di

import com.tarabut.domain.usecases.products.IScoresUseCase
import com.tarabut.domain.usecases.products.ScoresUseCaseImpl
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module


/****
 * Module which provides the factory instance of Usecase
 * Author: Lajesh Dineshkumar
 *****/
object UseCaseModule {
    fun load(){
        loadKoinModules(scoresUsecasModule)
    }

    val scoresUsecasModule = module {
        factory<IScoresUseCase> { ScoresUseCaseImpl(scoresRepository = get()) }
    }
}