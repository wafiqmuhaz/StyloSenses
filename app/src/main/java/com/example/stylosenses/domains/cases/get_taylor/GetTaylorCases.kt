package com.example.stylosenses.domains.cases.get_taylor

import com.example.stylosenses.commons.Resource
import com.example.stylosenses.domains.models.ProductModel
import com.example.stylosenses.domains.repos.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProductUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    operator fun invoke(): Flow<Resource<List<ProductModel>>> = flow {
        try {
            emit(Resource.Loading())
            val products = repository.getProduct()?.map { it }
            emit(Resource.Success(data = products))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.localizedMessage ?: "An unexpected error occurred"))
        }
    }
}