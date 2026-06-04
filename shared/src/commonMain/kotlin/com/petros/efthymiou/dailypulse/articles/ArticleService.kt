package com.petros.efthymiou.dailypulse.articles

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class ArticleService(
    private val httpClient: HttpClient
) {
    private val country = "us"
    private val apiKey = "15221eb155b2450092ecb7bfd44aca01"
    private val category = "business"

    suspend fun fetchArticles(

    ): List<ArticleRaw>{

        val response: ArticleResponse = httpClient.get("https://newsapi.org/v2/top-headlines") {
            parameter("country", country)
            parameter("category", category)
            parameter("apiKey", apiKey)
        }.body()
        return response.article
    }
}