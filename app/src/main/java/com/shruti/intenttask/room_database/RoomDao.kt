package com.shruti.intenttask.room_database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface RoomDao {
    @Insert
    fun insertNotes(roomEntity: RoomEntity)
    @Query ("Select * from RoomEntity")
    fun getNotes(): List<RoomEntity>
    @Update
    fun updateNotes(roomEntity: RoomEntity)
    @Delete
    fun deleteNotes(roomEntity: RoomEntity)

}