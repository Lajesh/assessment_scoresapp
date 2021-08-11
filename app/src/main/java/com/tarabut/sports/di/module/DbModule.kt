package com.tarabut.sports.di.module

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.tarabut.sports.SportsApp
import com.tarabut.data.datasource.local.database.AppDb
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

/****
 * Database Module
 * Author: Lajesh Dineshkumar
 *****/
object DbModule {
    fun load() {
        loadKoinModules(dbModules )
    }

    private val dbModules = module {

        single {
            Room.databaseBuilder(
                SportsApp.applicationContext(), AppDb::class.java, "sportsapp.db"
            ).allowMainThreadQueries()
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onDestructiveMigration(db: SupportSQLiteDatabase) {
                        // Clear data
                    }
                })
                // Clear DB while upgrade or downgrade
                .fallbackToDestructiveMigration()
                .build()
        }

        single {
            get<AppDb>().scoreDao()
        }


    }
}