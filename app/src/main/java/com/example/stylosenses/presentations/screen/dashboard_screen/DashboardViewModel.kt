package com.example.stylosenses.presentations.screen.dashboard_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stylosenses.commons.Resource
import com.example.stylosenses.domains.cases.get_taylor.GetProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val productUseCase: GetProductUseCase
) : ViewModel() {
    private val _state = mutableStateOf<ProductState>(ProductState())
    val state: State<ProductState> = _state

    init {
        getProduct()
    }

    private fun getProduct() {
        productUseCase().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = ProductState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = ProductState(product = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value =
                        ProductState(errorMessage = result.message ?: "Unexpected error.")
                }
            }
        }.launchIn(viewModelScope)
    }
}