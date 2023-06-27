package com.example.a22byte.di

import com.example.a22byte.viewModels.MainActivityViewModel
import com.example.a22byte.viewModels.QuestionsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        MainActivityViewModel(get())
    }

    viewModel {
        QuestionsViewModel(get())
    }
}