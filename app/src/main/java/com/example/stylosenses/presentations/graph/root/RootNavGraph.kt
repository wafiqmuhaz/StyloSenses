package com.example.stylosenses.presentations.graph.root

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.stylosenses.presentations.graph.Graph
import com.example.stylosenses.presentations.graph.auth.authNavGraph
import com.example.stylosenses.presentations.screen.home_screen.component.HomeScreen

@Composable
fun RootNavigationGraph(navHostController: NavHostController, context: Context) {
    NavHost(
        navController = navHostController,
        route = Graph.ROOT,
        startDestination = Graph.AUTHENTICATION,
    ) {
        authNavGraph(navHostController, context)
        composable(route = Graph.HOME) {
            HomeScreen()
        }
    }
}