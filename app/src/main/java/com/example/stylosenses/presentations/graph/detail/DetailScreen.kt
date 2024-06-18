package com.example.stylosenses.presentations.graph.detail

sealed class DetailScreen( val route: String) {
    object CartScreen : DetailScreen("cart_screen")
    object NotificationScreen : DetailScreen("notification_screen")
    object ProductDetailScreen : DetailScreen("product_detail_screen")
    object ChatDetailScreen : DetailScreen("product_detail_screen")
}