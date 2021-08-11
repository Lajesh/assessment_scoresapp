package com.tarabut.data.datasource.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tarabut.data.datasource.local.dao.ScoreDao
import com.tarabut.data.datasource.local.entity.Score

/****
 * Application Database
 * Author: Lajesh Dineshkumar
 *****/
@Database(
    entities = [Score::class],
    version = 1,
    exportSchema = false
)
abstract class AppDb : RoomDatabase() {
    abstract fun scoreDao() : ScoreDao
}