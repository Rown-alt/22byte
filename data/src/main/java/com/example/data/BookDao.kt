package com.example.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface BookDao {
    @Query("SELECT * FROM books")
    fun getAll(): List<Book>

    @Query("SELECT (SELECT COUNT(*) FROM books) == 0")
    fun isEmpty(): Boolean

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg books: Book)

    @Delete
    fun delete(book: Book)
}
