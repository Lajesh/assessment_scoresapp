package com.tarabut.domain.usecases.products

import com.tarabut.domain.common.ResultState
import com.tarabut.domain.entity.response.products.ScoresEntity
import com.tarabut.domain.usecases.base.BaseUseCase
import kotlinx.coroutines.flow.Flow

/*******
 * Keep all products related usecases over here
 * Author: Lajesh Dineshkumar
 ********/
interface IScoresUseCase : BaseUseCase {
    fun getScores() : Flow<ResultState<List<ScoresEntity.Score>>>
    fun getScoresOfPopularMatches() : Flow<ResultState<List<ScoresEntity.Score>>>
}