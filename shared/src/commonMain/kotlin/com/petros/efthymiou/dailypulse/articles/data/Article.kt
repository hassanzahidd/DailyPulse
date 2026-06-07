package com.petros.efthymiou.dailypulse.articles.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleRaw(
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String?,
    @SerialName("publishedAt")
    val publishedAt:String,
    @SerialName("urlToImage")
    val urlToImage:String?,

)
data class Article(
    val title: String,
    val date: String,
    val desc: String?,
    val imageUrl: String?
)