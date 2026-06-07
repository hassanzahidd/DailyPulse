package com.petros.efthymiou.dailypulse.di

import com.petros.efthymiou.dailypulse.articles.di.ArticleModule

val sharedKoinModule = listOf(NetworkModule, ArticleModule)