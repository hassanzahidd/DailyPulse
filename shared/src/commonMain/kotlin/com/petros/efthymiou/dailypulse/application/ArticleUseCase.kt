package com.petros.efthymiou.dailypulse.application

import com.petros.efthymiou.dailypulse.articles.data.Article
import com.petros.efthymiou.dailypulse.articles.data.ArticleRaw
import com.petros.efthymiou.dailypulse.articles.data.ArticleRepository
import com.petros.efthymiou.dailypulse.articles.network.Source
import com.petros.efthymiou.dailypulse.articles.network.SourceAfterNetwork
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.parseOrNull
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlin.math.abs
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

class ArticleUseCase(private val repo: ArticleRepository) {
    suspend fun getArticles(forceRefresh: Boolean): List<Article> {
        val articlesRaw = repo.getArticles(forceRefresh)
        return mapArticle(articlesRaw)
    }

    private fun mapArticle(articleRaw: List<ArticleRaw>): List<Article>{
        return articleRaw.map {
            raw ->
            Article(
                title = raw.title,
                date = getDaysAgoString(raw.publishedAt),
                imageUrl = raw.urlToImage,
                desc = raw.description
            )
        }
    }

    suspend fun getSources(): List<Source>{
        val sources = repo.getSources()
        sources.forEach {
            source ->
            SourceAfterNetwork(
                name = source.name,
                language = source.language,
                desc = source.language
            )

        }
        return sources
    }

    @OptIn(ExperimentalTime::class)
    private fun getDaysAgoString(date: String?): String{
        val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
        val days = today.daysUntil(
            (date?.let { Instant.parseOrNull(it) }?.toLocalDateTime(TimeZone.currentSystemDefault())?.date
                ?: LocalDate.toString()) as LocalDate
        )

        val result = when {
            abs(days) > 1 -> "${abs(days)} ago"
            abs(days) == 1 -> "Yesterday"
            else -> "Today"
        }

        return result
    }
}