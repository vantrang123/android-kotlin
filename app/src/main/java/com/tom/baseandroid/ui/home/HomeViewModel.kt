package com.tom.baseandroid.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tom.baseandroid.base.BaseViewModel
import com.tom.baseandroid.data.model.Data
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
    private val _categories = MutableLiveData<MutableList<Data.Category>>()
    val categories: LiveData<MutableList<Data.Category>> get() = _categories


    fun getProducts(categoryId: String) {
//        viewModelScope.launch(main) {
//            try {
//                isLoading.postValue(true)
//                val result = withContext(io) { async { productRepo.observerProducts(categoryId) } }
//                result.await().apply {
//                    isLoading.postValue(false)
//                }
//            } catch (e: Exception) {
//                handleError(e.message)
//            }
//        }
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