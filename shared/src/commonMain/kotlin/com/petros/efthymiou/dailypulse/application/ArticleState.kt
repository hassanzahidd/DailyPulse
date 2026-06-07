package com.petros.efthymiou.dailypulse.application

import com.petros.efthymiou.dailypulse.articles.data.Article
import com.petros.efthymiou.dailypulse.articles.network.Source

data class ArticleState(
    val articles: List<Article> = listOf(),
    val sources : List<Source> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)