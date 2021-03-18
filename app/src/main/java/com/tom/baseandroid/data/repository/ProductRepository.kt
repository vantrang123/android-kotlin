package com.tom.baseandroid.data.repository

import com.tom.baseandroid.data.remote.ProductRemote
import javax.inject.Inject
import javax.inject.Singleton

/**
 *Created by VanTrang on 8/22/2019.
 */
@Singleton
class ProductRepository  @Inject constructor(
    private val remote: ProductRemote
) {
    suspend fun observerProducts(categoryId: String) = remote.getProductsByCategory(categoryId)
}