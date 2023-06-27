package com.example.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface BookDao {
    @Query("SELECT * FROM books WHERE bookName=:name")
    fun getBook(name: String): Boolean

    @Insert
    fun insertAll(vararg book: Book)

    @Delete
    fun delete(book: Book)
}
