package com.example.stylosenses.presentations.screen.dashboard_screen

import com.example.stylosenses.domains.models.ProductModel

data class ProductState(
    val isLoading: Boolean = false,
    val product: List<ProductModel>? = null,
    val errorMessage: String = ""
)