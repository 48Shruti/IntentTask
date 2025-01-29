package com.shruti.intenttask

import android.icu.text.Transliterator.Position
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Update

@Dao
interface RoomInterface {
    @Update
    fun update(roomEntity: RoomEntity)
    @Delete
    fun delete(roomEntity: RoomEntity)
}