package com.petros.efthymiou.dailypulse.articles.di

import com.petros.efthymiou.dailypulse.articles.ArticleService
import com.petros.efthymiou.dailypulse.articles.ArticleUseCase
import com.petros.efthymiou.dailypulse.articles.ArticlesViewModel
import org.koin.dsl.module

val ArticleModule = module {
    single<ArticleService> {
        ArticleService(get())
    }
    single<ArticleUseCase>{
        ArticleUseCase(get())
    }
    single<ArticlesViewModel>{
        ArticlesViewModel(get())
    }
}