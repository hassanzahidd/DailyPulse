package com.petros.efthymiou.dailypulse.articles

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleRaw(
    @SerialName("source")
    val source : Source?,
    @SerialName("author")
    val author: String?,
    @SerialName("title")
    val title: String?,
    @SerialName("description")
    val description: String?,
    @SerialName("url")
    val url: String?,
    @SerialName("urlToImage")
    val urlToImage:String?,
    @SerialName("publishedAt")
    val publishedAt:String?,
    @SerialName("content")
    val content: String?
)
@Serializable
data class Source(
    @SerialName("id")
    val id:String?,
    @SerialName("name")
    val name: String?
)

data class Article(
    val title: String?,
    val date: String?,
    val desc: String?,
    val imageUrl: String?
)