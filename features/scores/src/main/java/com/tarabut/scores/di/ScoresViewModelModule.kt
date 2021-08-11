package com.tarabut.scores.di

import com.tarabut.scores.view.fragment.products.ScoreDetailsViewModel
import com.tarabut.scores.view.fragment.products.ScoresListingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

/****
 * File Description
 * Author: Lajesh Dineshkumar
 *****/
object ScoresViewModelModule {
    fun load() {
        loadKoinModules(module {

            viewModel {
                ScoresListingViewModel(get())
            }

            viewModel {
                ScoreDetailsViewModel()
            }

        })
    }
}