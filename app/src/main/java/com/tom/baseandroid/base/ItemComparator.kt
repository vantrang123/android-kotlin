package com.tom.baseandroid.base


interface ItemComparator<in T> {

    fun areItemsTheSame(item1: T, item2: T): Boolean

    fun areContentsTheSame(item1: T, item2: T): Boolean
}