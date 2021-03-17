package com.tom.baseandroid.extensions

import android.content.res.Resources
import kotlin.Int

fun Int?.isTrue() = this == 1

val Int.dp: Int
    get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()

val Int.sp: Int
    get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()