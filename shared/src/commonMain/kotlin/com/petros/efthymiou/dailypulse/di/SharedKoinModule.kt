package com.petros.efthymiou.dailypulse.di

import com.petros.efthymiou.dailypulse.articles.di.ArticleModule
import org.koin.dsl.module

val sharedKoinModule = listOf(NetworkModule, ArticleModule)