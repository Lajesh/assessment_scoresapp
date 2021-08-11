package com.tarabut.data.datasource.local.dao

import androidx.room.Insert
import androidx.room.Update

/****
 * All the DAO should be extended from this base class.
 * Author: Lajesh Dineshkumar
 *****/
interface BaseDao<T> {

    /**
     * Insert an object in the database.
     *
     * @param obj the object to be inserted.
     */
    @Insert
    suspend fun insert(obj: T): Long

    /**
     * Update an object from the database.
     *
     * @param obj the object to be updated
     */
    @Update
    suspend fun update(obj: T): Void

    /**
     * Delete an object from the database
     *
     * @param obj the object to be deleted
     */
    suspend fun delete(): Int

}