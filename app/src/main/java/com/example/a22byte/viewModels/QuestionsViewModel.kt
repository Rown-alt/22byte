package com.example.a22byte.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.Book
import com.example.data.BookDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuestionsViewModel(private val bookDao: BookDao): ViewModel() {
    val books = MutableLiveData<List<Book>>()

    fun getBooks(){
        viewModelScope.launch(Dispatchers.IO) {
            books.postValue(bookDao.getAll())
        }
    }
}