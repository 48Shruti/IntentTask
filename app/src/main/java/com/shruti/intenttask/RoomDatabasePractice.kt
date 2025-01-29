package com.shruti.intenttask

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(version = 1, entities = [RoomEntity::class])
abstract class RoomDatabasePractice : RoomDatabase() {
    abstract fun roomInterface(): RoomInterface

    companion object {
        var roomDataBasePractice: RoomDatabasePractice? = null
        fun getDatabase(context: Context): RoomDatabasePractice {
            if (roomDataBasePractice == null) {
                roomDataBasePractice = Room.databaseBuilder(
                    context,
                    RoomDatabasePractice::class.java,
                    context.resources.getString(R.string.app_name)
                ).build()
            }
            return roomDataBasePractice!!
        }
    }
}