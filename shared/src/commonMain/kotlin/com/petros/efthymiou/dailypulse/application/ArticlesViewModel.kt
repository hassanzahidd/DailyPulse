package com.petros.efthymiou.dailypulse.application

import com.petros.efthymiou.dailypulse.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
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
        getArticles(forceRefresh = true)
    }
    private fun getArticles(forceRefresh:Boolean = false){
        scope.launch {
            val fetchedArticles = useCase.getArticles(forceRefresh = forceRefresh)
            _articleState.emit(ArticleState(articles = fetchedArticles))
        }
    }
    private fun getSources(){
        scope.launch {
            val fetchedSources = useCase.getSources()
            _articleState.emit(ArticleState(sources = fetchedSources))
        }
    }
}