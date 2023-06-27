package com.example.a22byte.viewModels

import com.example.data.BookDao

class MainActivityViewModel(private val bookDao: BookDao) : DataViewModel(bookDao)