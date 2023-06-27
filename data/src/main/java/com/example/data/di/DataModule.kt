package com.example.data.di

import androidx.room.Room
import com.example.data.BookDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module{
    single{
        Room.databaseBuilder(
            androidContext(),
            BookDatabase::class.java, "books"
        ).build()
    }
    single {
        get<BookDatabase>().bookDao()
    }
}