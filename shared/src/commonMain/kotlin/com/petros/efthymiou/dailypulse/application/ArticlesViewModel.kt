package com.petros.efthymiou.dailypulse.application

import com.petros.efthymiou.dailypulse.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ArticlesViewModel(
    private val useCase: ArticleUseCase
): BaseViewModel() {
    private val _articleState: MutableStateFlow<ArticleState> =
        MutableStateFlow(ArticleState(loading = true))
    init {
        getArticles()
        getSources()
    }
    val articleState get() = _articleState
    fun forceRefresh() {
        _articleState.update { it.copy(loading = true) }
        getArticles(forceRefresh = true)
    }
    private fun getArticles(forceRefresh:Boolean = false){
        scope.launch {
            val fetchedArticles = useCase.getArticles(forceRefresh = forceRefresh)
            _articleState.update{it.copy(articles = fetchedArticles, loading = false)}
        }
    }
    private fun getSources(){
        scope.launch {
            val fetchedSources = useCase.getSources()
            _articleState.update { it.copy(sources = fetchedSources)}
        }
    }
}