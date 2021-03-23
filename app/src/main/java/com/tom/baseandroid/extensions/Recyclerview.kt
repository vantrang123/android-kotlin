package com.tom.baseandroid.extensions

import androidx.recyclerview.widget.RecyclerView
import com.tom.baseandroid.utils.EndlessRecyclerOnScrollListener

fun RecyclerView.onLoadMore(onLoadMore: () -> Unit) {
    this.addOnScrollListener(object : EndlessRecyclerOnScrollListener() {
        override fun onLoadMore() {
            onLoadMore.invoke()
        }
    })
}