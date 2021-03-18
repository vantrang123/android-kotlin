package com.tom.baseandroid.base

/**
 *Created by VanTrang.
 */
open class BaseResponse<T> {
    var success: Boolean = false
    var serverCode: Int? = null
    var message: String? = null
    var data: T? = null
}