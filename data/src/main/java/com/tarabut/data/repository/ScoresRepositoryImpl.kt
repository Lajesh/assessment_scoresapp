package com.tarabut.data.repository

import com.tarabut.data.datasource.remote.api.IScoresApi
import com.tarabut.data.mapper.dtotoentity.map
import com.tarabut.domain.common.ResultState
import com.tarabut.domain.entity.response.products.ScoresEntity
import com.tarabut.domain.repository.IScoresRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/*******
 * ProductRepository Implementation
 * Author: Lajesh Dineshkumar
 ********/
class ScoresRepositoryImpl(private val scoresApi: IScoresApi) : BaseRepositoryImpl(),
    IScoresRepository {
    override fun getScores(): Flow<ResultState<List<ScoresEntity.Score>>> = flow {
        emit(apiCall { scoresApi.getScores().map() })
    }

    override fun getScoresOfPopularMatches(): Flow<ResultState<List<ScoresEntity.Score>>> = flow {
        emit(apiCall { scoresApi.getScoresOfPopularMatches().map() })
    }

}