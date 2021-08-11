package com.tarabut.data.datasource.remote.dto

import com.google.gson.annotations.SerializedName
import java.util.*

/*******
 * Products DTO
 * Author: Lajesh Dineshkumar
 ********/
sealed class ScoresDto {
    data class Score(
        @SerializedName("Team_A") val teamA: String?,
        @SerializedName("Team_B") val teamB: String?,
        @SerializedName("Team_A_TAG") val teamATag: String?,
        @SerializedName("Team_B_TAG") val teamBTag: String?,
        @SerializedName("Team_A_Score") val scoreTeamA: String?,
        @SerializedName("Team_B_Score") val scoreTeamB: String?,
        @SerializedName("link_A") val linkA: String?,
        @SerializedName("link_B") val linkB: String?,
        @SerializedName("Date") val date: Date?,
        @SerializedName("Match_Summary") val summary: String?
    ) : ScoresDto()

}