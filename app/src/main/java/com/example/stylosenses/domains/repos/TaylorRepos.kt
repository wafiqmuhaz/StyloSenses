package com.example.stylosenses.domains.repos

import com.example.stylosenses.domains.models.ProductModel

interface ProductRepository {
    suspend fun getProduct(): List<ProductModel>? = null
    suspend fun getProductDetail(id: Int): ProductModel? = null
}