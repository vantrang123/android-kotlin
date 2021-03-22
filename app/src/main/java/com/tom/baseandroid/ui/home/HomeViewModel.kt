package com.tom.baseandroid.ui.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tom.baseandroid.base.BaseViewModel
import com.tom.baseandroid.data.model.DataCategory
import com.tom.baseandroid.data.model.DataProduct
import com.tom.baseandroid.data.model.ErrorMessage
import com.tom.baseandroid.data.repository.CategoryRepository
import com.tom.baseandroid.data.repository.ProductRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Named

class HomeViewModel @Inject constructor(
    private val productRepo: ProductRepository,
    private val categoryRepo: CategoryRepository,
    @Named("IO") private val io: CoroutineDispatcher,
    @Named("MAIN") private val main: CoroutineDispatcher
) : BaseViewModel() {
    private val _categories = MutableLiveData<MutableList<DataCategory.Category>>()
    val categories: LiveData<MutableList<DataCategory.Category>> get() = _categories

    private val _products = MutableLiveData<MutableList<DataProduct.Product>>()
    val products: LiveData<MutableList<DataProduct.Product>> get() = _products

    fun getProducts() {
        viewModelScope.launch(main) {
            try {
                isLoading.postValue(true)
                val result =
                    withContext(io) { async { productRepo.observerProducts("221366989", 0) } } /** need change shop id **/
                result.await().apply {
                    isLoading.postValue(false)
                    _products.postValue(data?.products)
                }
            } catch (e: Exception) {
                handleError(e.message)
            }
        }
    }

    fun getCategories() {
        viewModelScope.launch(main) {
            try {
                isLoading.postValue(true)
                val result = withContext(io) { async { categoryRepo.observerCategories() } }
                result.await().apply {
                    isLoading.postValue(false)
                    _categories.postValue(data?.categories)
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