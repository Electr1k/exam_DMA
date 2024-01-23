package com.example.exam

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DaoInterface {
    @Query("SELECT * FROM books ORDER BY name ASC")
    fun getAllBook(): List<Book>

    @Insert
    fun insertBook(book: Book)
}