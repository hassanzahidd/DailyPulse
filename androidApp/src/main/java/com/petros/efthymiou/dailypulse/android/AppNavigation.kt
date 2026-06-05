package com.petros.efthymiou.dailypulse.android

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.petros.efthymiou.dailypulse.android.screens.AboutScreen
import com.petros.efthymiou.dailypulse.android.screens.ArticleScreen
import com.petros.efthymiou.dailypulse.android.screens.Screens
import com.petros.efthymiou.dailypulse.articles.ArticlesViewModel


@Composable
fun AppScaffold(
) {
    val navController = rememberNavController()
    Scaffold {
        AppNavHost(
            navController = navController,
            modifier = Modifier.padding(it)
        )
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = Screens.ARTICLE_SCREEN.name,
        modifier = modifier
    ) {
        composable(Screens.ARTICLE_SCREEN.name) {
            ArticleScreen(
                onAboutButtonClick = { navController.navigate(Screens.ABOUT_SCREEN.name) },
            )
        }
        composable(Screens.ABOUT_SCREEN.name) {
            AboutScreen(
                onUpButtonClick = { navController.popBackStack() }
            )
        }
    }
}