package com.example.stylosenses.presentations.graph.detail

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.stylosenses.commons.Constrains
import com.example.stylosenses.presentations.graph.Graph
import com.example.stylosenses.presentations.screen.cart_screen.CartScreen
import com.example.stylosenses.presentations.screen.detail_chat_screen.ChatDetailScreen
import com.example.stylosenses.presentations.screen.detail_taylor_screen.component.TailorDetailsScreen
import com.example.stylosenses.presentations.screen.notif_screen.NotificationScreen

fun NavGraphBuilder.detailNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.DETAILS,
        startDestination = DetailScreen.ProductDetailScreen.route + "/{${Constrains.PRODUCT_ID_PARAM}}"
    ) {
        composable(DetailScreen.CartScreen.route) {
            CartScreen()
        }
        composable(DetailScreen.NotificationScreen.route) {
            NotificationScreen()
        }
        composable(DetailScreen.ProductDetailScreen.route + "/{productId}") {
            TailorDetailsScreen() {
                navController.popBackStack()
            }
        }
        composable(DetailScreen.ChatDetailScreen.route) {
            ChatDetailScreen()
        }
    }
}