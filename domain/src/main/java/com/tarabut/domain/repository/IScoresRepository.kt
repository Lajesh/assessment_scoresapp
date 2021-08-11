package com.tarabut.domain.repository

import com.tarabut.domain.common.ResultState
import com.tarabut.domain.entity.response.products.ScoresEntity
import kotlinx.coroutines.flow.Flow

/*******
 * Abstraction of Products repository
 * Author: Lajesh Dineshkumar
 ********/
interface IScoresRepository {
    fun getScores() : Flow<ResultState<List<ScoresEntity.Score>>>
    fun getScoresOfPopularMatches() : Flow<ResultState<List<ScoresEntity.Score>>>
}