package com.tom.baseandroid.data.model

data class BaseConfig constructor(
    val applicationID: String,
    val socketUrl: String,
    val endPoint: String,
    val type: String,
    val notificationChannelName: String
) {
}