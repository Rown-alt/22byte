package com.example.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "books")
data class Book(
    @PrimaryKey val bookName: String, //Плохо так делать, но id по номерам я давать не захотел
    @ColumnInfo (name = "book_first_line") val bookFirstLine: String,
    @ColumnInfo (name = "image_source") val imageSource: String?
)