package com.example.stylosenses.presentations.screen.detail_taylor_screen

import com.example.stylosenses.domains.models.ProductModel

data class ProductDetailState(
    val isLoading: Boolean = false,
    val productDetail: ProductModel? = null,
    val errorMessage: String = ""
)