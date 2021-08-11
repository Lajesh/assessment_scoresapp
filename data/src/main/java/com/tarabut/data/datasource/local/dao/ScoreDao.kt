package com.tarabut.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tarabut.data.datasource.local.entity.Score

/****
 * DAO for bank branches
 * Author: Lajesh Dineshkumar
 *****/
@Dao
interface ScoreDao : BaseDao<Score> {

    @Query("SELECT * FROM scores")
    suspend fun getScores(): List<Score>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override suspend fun insert(obj: Score): Long

    @Query("DELETE FROM scores")
    override suspend fun delete(): Int
}