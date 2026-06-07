package com.petros.efthymiou.dailypulse.articles.di

import com.petros.efthymiou.dailypulse.articles.data.ArticleDataSource
import com.petros.efthymiou.dailypulse.articles.data.ArticleRepository
import com.petros.efthymiou.dailypulse.articles.network.ArticleService
import com.petros.efthymiou.dailypulse.application.ArticleUseCase
import com.petros.efthymiou.dailypulse.application.ArticlesViewModel
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
    single<ArticleRepository>{
        ArticleRepository(get(), get())
    }
    single<ArticleDataSource>{
        ArticleDataSource(get())
    }
}