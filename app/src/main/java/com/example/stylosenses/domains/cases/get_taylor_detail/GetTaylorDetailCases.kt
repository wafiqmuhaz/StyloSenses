package com.example.stylosenses.domains.cases.get_taylor_detail

import com.example.stylosenses.commons.Resource
import com.example.stylosenses.domains.models.ProductModel
import com.example.stylosenses.domains.repos.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProductDetailUseCase @Inject constructor(private val repository: ProductRepository) {
    operator fun invoke(productId: Int): Flow<Resource<ProductModel>> = flow {
        try {
            emit(Resource.Loading())
            val data = repository.getProductDetail(productId)
            emit(Resource.Success(data = data))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }
    }

}