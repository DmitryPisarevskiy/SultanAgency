package com.example.sultanagency.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [
        FavouriteDbEntity::class
    ]
)
abstract class AppDataBase: RoomDatabase() {
    abstract fun getPublicationDao(): PublicationDAO
    companion object{
        fun getDB(context: Context): AppDataBase{
            return Room.databaseBuilder(
                context.applicationContext,
                AppDataBase::class.java,
                "main_db"
            ).build()
        }
    }
}