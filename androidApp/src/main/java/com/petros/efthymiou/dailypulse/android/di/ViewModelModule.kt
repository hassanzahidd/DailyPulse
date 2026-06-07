package com.petros.efthymiou.dailypulse.android.di

import com.petros.efthymiou.dailypulse.application.ArticlesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        ArticlesViewModel(get())
    }
}