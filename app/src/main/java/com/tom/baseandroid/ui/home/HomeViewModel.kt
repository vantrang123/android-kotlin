package com.tom.baseandroid.ui.home

import androidx.lifecycle.viewModelScope
import com.tom.baseandroid.base.BaseViewModel
import com.tom.baseandroid.data.model.ErrorMessage
import com.tom.baseandroid.data.repository.ProductRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Named

class HomeViewModel @Inject constructor(
    private val repository: ProductRepository,
    @Named("IO") private val io: CoroutineDispatcher,
    @Named("MAIN") private val main: CoroutineDispatcher
) : BaseViewModel() {
    fun getProductsByCategory(categoryId: String) {
        viewModelScope.launch(main) {
            try {
                isLoading.postValue(true)
                val result = withContext(io) { async { repository.observerProducts(categoryId) } }
                result.await().apply {
                    isLoading.postValue(false)
                }
            } catch (e: Exception) {
                handleError(e.message)
            }
        }
    }

    private fun handleError(message: String?) {
        isLoading.postValue(false)
        error.postValue(ErrorMessage(message = message ?: "Unknown error"))
    }
}