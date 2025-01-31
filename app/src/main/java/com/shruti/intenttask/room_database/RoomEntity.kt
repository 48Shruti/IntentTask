package com.shruti.intenttask.room_database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RoomEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo
    var name : String ? = " ",
    @ColumnInfo
    var rollNo : Int ?= 0,
    @ColumnInfo
    var classNo : Int ? = 0)
