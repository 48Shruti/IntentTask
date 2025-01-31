package com.shruti.intenttask.room_database

import android.icu.text.Transliterator.Position
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

interface RoomInterface {
    fun update(roomEntity: RoomEntity,position: Int)
    fun delete(roomEntity: RoomEntity,position: Int)
}