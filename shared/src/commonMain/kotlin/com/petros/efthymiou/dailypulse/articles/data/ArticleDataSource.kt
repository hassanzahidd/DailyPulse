package com.petros.efthymiou.dailypulse.articles.data

import com.petros.efthymiou.dailypulse.articles.network.Source
import petros.efthymiou.dailypulse.db.DailyoulseDatabase

class ArticleDataSource(private val database: DailyoulseDatabase) {
    fun getAllArticles(): List<ArticleRaw> =
        database.dailyPulseDatabaseQueries.selectAllArticles(::mapToArticlesRaw).executeAsList()


    fun insertArticle(
        articles: List<ArticleRaw>
    ){
        database.dailyPulseDatabaseQueries.transaction {
            articles.forEach { articleRaw ->
                insertSingleArticle(articleRaw)
            }
        }
    }

    private fun insertSingleArticle(article: ArticleRaw){
      database.dailyPulseDatabaseQueries.insetArticle(
          article.title,
          article.description,
          article.publishedAt,
          article.urlToImage
      )
    }

    fun clearAllArticles(){
        database.dailyPulseDatabaseQueries.removeAllArticles()
    }
    private fun mapToArticlesRaw(
        title:String,
        desc: String?,
        date:String,
        imageUrl:String?
    ) : ArticleRaw =
        ArticleRaw(
            title,
            desc,
            date,
            imageUrl
        )


    fun getAllSources(): List<Source> =
        database.dailyPulseDatabaseQueries.selectAllSources(::mapToSources).executeAsList()


    private fun mapToSources(
        name:String?,
        desc: String?,
        lang: String?
    ): Source =
       Source(
            name,
            desc,
            lang
        )

}