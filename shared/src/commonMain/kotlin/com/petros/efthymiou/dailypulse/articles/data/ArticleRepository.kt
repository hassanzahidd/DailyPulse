package com.petros.efthymiou.dailypulse.articles.data

import com.petros.efthymiou.dailypulse.articles.network.ArticleService
import com.petros.efthymiou.dailypulse.articles.network.Source

class ArticleRepository(
    private val dataSource: ArticleDataSource,
    private val service: ArticleService
) {

    suspend fun getArticles(forceRefresh: Boolean): List<ArticleRaw> {
        if (forceRefresh) {
            dataSource.clearAllArticles()
            return fetchArticles()
        }
        val articlesdb = dataSource.getAllArticles()

        if (articlesdb.isEmpty()) {
            return fetchArticles()
        }

        return articlesdb
    }

    private suspend fun fetchArticles(): List<ArticleRaw> {
        val fetchedArticles = service.fetchArticles()
        dataSource.insertArticle(fetchedArticles)
        return fetchedArticles
    }


    suspend fun getSources(): List<Source>{
        val fetchSources = service.fetchSources()
        val sourceDB= dataSource.getAllSources()
        if(sourceDB.isEmpty()){
            return fetchSources
        }
        return sourceDB
    }
}