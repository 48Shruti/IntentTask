package com.shruti.intenttask.room_database

import android.icu.text.Transliterator.Position
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface RoomInterface {
    @Insert
    fun insert(roomEntity: RoomEntity)
    @Query("Select * from RoomEntity")
    fun get() : List<RoomEntity>
    @Update
    fun update(roomEntity: RoomEntity)
    @Delete
    fun delete(roomEntity: RoomEntity)
}