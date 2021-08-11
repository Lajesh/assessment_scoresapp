package com.tarabut.data.mapper.dtotoentity

import com.tarabut.data.datasource.remote.dto.ScoresDto
import com.tarabut.domain.entity.response.products.ScoresEntity
import java.util.*
import kotlin.collections.ArrayList

/*******
 * KEEP all product DTO to entity mapping here
 * Author: Lajesh Dineshkumar
 ********/


fun ScoresDto.Score.map() = ScoresEntity.Score(
    teamA = teamA,
    teamB = teamB,
    teamATag = teamATag,
    teamBTag = teamBTag,
    scoreTeamA = scoreTeamA,
    scoreTeamB = scoreTeamB,
    linkA = linkA,
    linkB = linkB,
    date = date,
    summary = summary
)

fun List<ScoresDto.Score>.map(): List<ScoresEntity.Score> {
    val scoresList = ArrayList<ScoresEntity.Score>()
    forEach { item ->
        scoresList.add(
            ScoresEntity.Score(
                teamA = item.teamA,
                teamB = item.teamB,
                teamATag = item.teamATag,
                teamBTag = item.teamBTag,
                scoreTeamA = item.scoreTeamA,
                scoreTeamB = item.scoreTeamB,
                linkA = item.linkA,
                linkB = item.linkB,
                date = item.date,
                summary = item.summary

            )
        )
    }
    return scoresList
}

