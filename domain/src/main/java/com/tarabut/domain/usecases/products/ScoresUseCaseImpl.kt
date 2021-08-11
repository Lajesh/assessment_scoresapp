package com.tarabut.domain.usecases.products

import com.tarabut.domain.common.ResultState
import com.tarabut.domain.entity.response.products.ScoresEntity
import com.tarabut.domain.repository.IScoresRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.zip

/*******
 * Implementation of products use case
 * Author: Lajesh Dineshkumar
 ********/
class ScoresUseCaseImpl constructor(private val scoresRepository: IScoresRepository) :
    IScoresUseCase {
    override fun getScores(): Flow<ResultState<List<ScoresEntity.Score>>> {
        return scoresRepository.getScores()
    }

    override fun getScoresOfPopularMatches(): Flow<ResultState<List<ScoresEntity.Score>>> {
        return scoresRepository.getScoresOfPopularMatches()
    }
}