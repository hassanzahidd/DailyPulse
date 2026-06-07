package com.petros.efthymiou.dailypulse.di

import com.petros.efthymiou.dailypulse.application.ArticlesViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

fun koinInit() {
    val modules = sharedKoinModule + DatabaseModule
    startKoin {
        modules(modules)
    }
}

class ArticlesInjector : KoinComponent {
    val articleViewModel: ArticlesViewModel by inject()
}