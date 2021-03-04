package com.rikai.baseandroid.extensions

import android.content.Context

fun String?.getDefault(): String {
    return this ?: ""
}

fun Int?.getDefault(): Int {
    return this ?: 0
}

fun Double?.getDefault(): Double {
    return this ?: 0.0
}

fun Boolean?.getDefault(): Boolean {
    return this ?: false
}