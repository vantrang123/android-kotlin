package com.rikai.baseandroid.extensions

import androidx.recyclerview.widget.RecyclerView
import com.rikai.baseandroid.utils.EndlessRecyclerOnScrollListener

fun RecyclerView.onLoadMore(onLoadMore: () -> Unit) {
    this.addOnScrollListener(object: EndlessRecyclerOnScrollListener(){
        override fun onLoadMore() {
            onLoadMore.invoke()
        }
    })
}