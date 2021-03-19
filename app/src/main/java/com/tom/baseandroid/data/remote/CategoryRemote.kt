package com.tom.baseandroid.data.remote

import javax.inject.Inject

/**
 *Created by VanTrang.
 */
class CategoryRemote @Inject constructor(private val service: Service) {
    suspend fun getCategories() = service.getCategories()
}