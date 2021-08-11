package com.tarabut.sports.di

import com.tarabut.core.di.module.application.ApiModule
import com.tarabut.data.di.RepositoryModule
import com.tarabut.domain.di.UseCaseModule

/****
 * Main Koin DI component which helps to configure
 * Mockwebserver, Usecase and repository
 * Author: Lajesh Dineshkumar
 *****/

fun configureTestAppComponent(baseApi: String) = listOf(
    mockwebserverDITest,
    configureNetworkModuleForTest(baseApi),
    ApiModule.apiModules,
    UseCaseModule.scoresUsecasModule,
    RepositoryModule.repositoryModules
)