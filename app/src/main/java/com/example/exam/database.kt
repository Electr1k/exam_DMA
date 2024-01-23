package com.example.exam

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Book::class],version = 1)
abstract class DataBase: RoomDatabase() {
    abstract fun getDao(): DaoInterface

    companion object{
        fun getDatabase(context: Context): DataBase {
            return Room.databaseBuilder(
                context.applicationContext,
                DataBase::class.java,
                "booksDB.db"
            ).build()
        }
    }
}