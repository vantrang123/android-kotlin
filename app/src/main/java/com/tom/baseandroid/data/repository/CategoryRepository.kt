package com.tom.baseandroid.data.repository

import com.tom.baseandroid.data.remote.CategoryRemote
import javax.inject.Inject

/**
 *Created by VanTrang.
 */
class CategoryRepository @Inject constructor(
        private val remote: CategoryRemote
) {
    suspend fun observerCategories() = remote.getCategories()
}