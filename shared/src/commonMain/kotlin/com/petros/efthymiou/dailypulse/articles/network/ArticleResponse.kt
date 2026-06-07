package com.petros.efthymiou.dailypulse.articles.network

import com.petros.efthymiou.dailypulse.articles.data.ArticleRaw
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleResponse(
    @SerialName("status")
    val status: String,
    @SerialName("totalResults")
    val totalResults: Int,
    @SerialName("articles")
    val article: List<ArticleRaw>
)