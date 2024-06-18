package com.example.stylosenses.domains.models

import androidx.compose.ui.graphics.Color

data class ProductModel(
    val id: Int,
    val title: String,
    val images: List<Int>,
    val colors: List<Color>,
    val rating: Double,
//    val price: Double,
    val price: String,
    val isFavourite: Boolean,
    val isPopular: Boolean,
    val description: String
)