package com.tarabut.data.datasource.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/****
 * Branch model
 * Author: Lajesh Dineshkumar
 *****/
@Entity(tableName = "scores")
data class Score(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val teamA: String?,
    val teamB: String?,
    val teamATag: String?,
    val teamBTag: String?,
    val scoreTeamA: String?,
    val scoreTeamB: String?,
    val linkA: String?,
    val linkB: String?,
    val date: String?,
    val summary: String?
)
