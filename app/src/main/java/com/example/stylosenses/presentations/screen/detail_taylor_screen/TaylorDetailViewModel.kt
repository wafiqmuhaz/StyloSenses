package com.example.stylosenses.presentations.screen.detail_taylor_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stylosenses.commons.Constrains
import com.example.stylosenses.commons.Resource
import com.example.stylosenses.domains.cases.get_taylor_detail.GetProductDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val getProductDetailUseCase: GetProductDetailUseCase,
    stateHandle: SavedStateHandle
) : ViewModel() {
    //state
    private val _state = mutableStateOf<ProductDetailState>(ProductDetailState())
    val state: State<ProductDetailState> = _state

    init {

        val productId = stateHandle.get<String>(Constrains.PRODUCT_ID_PARAM)
        getProductDetail(productId!!.toInt())
    }

    private fun getProductDetail(productId: Int) {
        getProductDetailUseCase(productId).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = ProductDetailState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = ProductDetailState(productDetail = result.data)

                }
                is Resource.Error -> {
                    _state.value = ProductDetailState(errorMessage = result.message!!)
                }
            }

        }.launchIn(viewModelScope)
    }
}