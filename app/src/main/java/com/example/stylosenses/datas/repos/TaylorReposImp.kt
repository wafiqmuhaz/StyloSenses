package com.example.stylosenses.datas.repos

import com.example.stylosenses.datas.dummy_db.DemoDB
import com.example.stylosenses.domains.models.ProductModel
import com.example.stylosenses.domains.repos.ProductRepository
import javax.inject.Inject

class ProductRepositoryImp @Inject constructor(
    private val demoDB: DemoDB
) : ProductRepository {
    override suspend fun getProduct(): List<ProductModel> {
        return demoDB.getProduct()
    }

    override suspend fun getProductDetail(id: Int): ProductModel {
        return demoDB.getProduct()[id-1]
    }
}