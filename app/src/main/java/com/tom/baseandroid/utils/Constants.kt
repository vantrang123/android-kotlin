package com.tom.baseandroid.utils

import com.tom.baseandroid.BuildConfig

/**
 * Created by vantrang on 8/16/20.
 */
object Constants {
    /*Socket IO*/
    /*Listener*/
    const val ON_CHANGED_ORDER_STATUS = "ON_CHANGED_ORDER_STATUS"
    const val ON_CHANGED_SHOPPING_ORDER_STATUS = "ON_CHANGED_SHOPPING_ORDER_STATUS"
    const val ON_CHANGED_SUBSCRIPTION = "ON_CHANGED_SUBSCRIPTION"
    const val ON_EDIT_ORDER = "ON_EDIT_ORDER"
    const val ON_CHANGE_SHOP_CONFIRM = "ON_CHANGE_SHOP_CONFIRM"
    const val ON_TRACKING_STAFF_LOCATION = "TRACKING_STAFF_LOCATION"

    const val SOCKET_URL = BuildConfig.BASE_URL
    const val KEY_BEARER = "Bearer"

    private const val BASE_URL_MALAYSIA = BuildConfig.BASE_URL_MALAYSIA
    private const val BASE_URL_THAILAND = BuildConfig.BASE_URL_THAILAND
    const val LIMIT_ITEM_PAGE = 10

    /*API*/
    const val API_PRODUCTS_BY_CATEGORY = "${BASE_URL_MALAYSIA}category/{category_id}/list-items"

}