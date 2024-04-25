package com.example.sultanagency.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.sultanagency.data.firebase.PublicationDB

@Database(
    version = 1,
    entities = [
        PublicationDB::class
    ]
)
abstract class AppDataBase: RoomDatabase() {
    abstract fun getPublicationDao(): PublicationDAO
    companion object{
        private var instance: AppDataBase? = null
        fun getDB(context: Context): AppDataBase {
            if (instance==null) {
                synchronized(this) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDataBase::class.java,
                        "main_db"
                    ).build()
                }
            }
            return instance!!
        }
    }
}