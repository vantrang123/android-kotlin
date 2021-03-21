package com.tom.baseandroid.data.remote

import com.tom.baseandroid.base.BaseResponse
import com.tom.baseandroid.data.model.Data
import com.tom.baseandroid.data.model.Product
import com.tom.baseandroid.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Service {
    @GET(Constants.API_PRODUCTS_BY_CATEGORY)
    suspend fun getProductsByCategory(
        @Path("category_id") categoryId: String,
        @Query("limit") limit: Int = Constants.LIMIT_ITEM_PAGE
    ): BaseResponse<List<Product>>

    @GET(Constants.API_CATEGORIES)
    suspend fun getCategories(): BaseResponse<Data>

    @GET(Constants.API_PRODUCTS)
    suspend fun getProducts(
        @Query("limit") limit: Int = Constants.LIMIT_ITEM_PAGE
    ): BaseResponse<MutableList<Product>>
}