package com.petros.efthymiou.dailypulse.articles

import com.petros.efthymiou.dailypulse.BaseViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json


class ArticlesViewModel: BaseViewModel() {
    private val _articleState: MutableStateFlow<ArticleState> = MutableStateFlow(ArticleState(loading = true))
    private val useCase: ArticleUseCase
    init {
        val client = HttpClient{
            install(ContentNegotiation){
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }

        val service = ArticleService(client)

        useCase = ArticleUseCase(service)

        getArticles()

    }
    val articleState get() = _articleState
    private fun getArticles(){
        scope.launch {
            val fetchedArticles = useCase.getArticles()
            delay(500)
            _articleState.emit(ArticleState(articles = fetchedArticles))
        }
    }
}
