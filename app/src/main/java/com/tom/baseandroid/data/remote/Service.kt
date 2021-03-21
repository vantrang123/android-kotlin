package com.tom.baseandroid.data.remote

import com.tom.baseandroid.base.BaseResponse
import com.tom.baseandroid.data.model.DataCategory
import com.tom.baseandroid.data.model.DataProduct
import com.tom.baseandroid.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Service {

    @GET(Constants.API_CATEGORIES)
    suspend fun getCategories(): BaseResponse<DataCategory>

    @GET(Constants.API_PRODUCTS_BY_SHOP)
    suspend fun getProducts(
            @Path("shop_id") shopId: String,
            @Query("limit") limit: Int = Constants.LIMIT_ITEM_PAGE,
            @Query("offset") offset: Int = 0
    ): BaseResponse<DataProduct>
}