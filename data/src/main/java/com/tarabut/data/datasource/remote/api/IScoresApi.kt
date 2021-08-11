package com.tarabut.data.datasource.remote.api

import com.tarabut.data.datasource.remote.dto.ScoresDto
import retrofit2.http.GET

/****
 * API endpoint of Authentication related service calls
 * Author: Lajesh Dineshkumar
 *****/
interface IScoresApi {

    @GET("fa50249f-00b5-4683-a4da-95113cf979d6")
    suspend fun getScores() : List<ScoresDto.Score>

    @GET("78e0c554-95a3-4b0e-9ce0-a736f90cbb83")
    suspend fun getScoresOfPopularMatches() : List<ScoresDto.Score>
}