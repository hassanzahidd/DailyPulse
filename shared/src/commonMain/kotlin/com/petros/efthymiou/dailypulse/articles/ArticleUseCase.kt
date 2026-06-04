package com.petros.efthymiou.dailypulse.articles

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

class ArticleUseCase(private val articleService: ArticleService) {
    suspend fun getArticles(): List<Article> {
        val articlesRaw = articleService.fetchArticles()
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