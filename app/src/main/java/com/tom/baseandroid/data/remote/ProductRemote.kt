package com.tom.baseandroid.data.remote

import javax.inject.Inject

/**
 *Created by VanTrang on 8/22/2019.
 */
class ProductRemote @Inject constructor(private val service: Service) {
    suspend fun getProductsByCategory(categoryId: String) = service.getProductsByCategory(categoryId)
}