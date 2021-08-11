package com.tarabut.domain.entity.response.products

import java.util.*

/*******
 * Scores Entity
 * Author: Lajesh Dineshkumar
 ********/
sealed class ScoresEntity {

    data class Score(
        val teamA: String?,
        val teamB: String?,
        val teamATag: String?,
        val teamBTag: String?,
        val scoreTeamA: String?,
        val scoreTeamB: String?,
        val linkA: String?,
        val linkB: String?,
        val date: Date?,
        val summary: String?
    ) : ScoresEntity()

}
