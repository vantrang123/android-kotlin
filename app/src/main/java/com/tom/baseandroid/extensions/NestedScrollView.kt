package com.tom.baseandroid.extensions

import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun NestedScrollView.onLoadMore(recyclerView: RecyclerView, onLoadMore: () -> Unit) {
    this.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, _, scrollY, _, oldScrollY ->
        if (v.getChildAt(v.childCount - 1) != null) {
            if ((scrollY >= (v.getChildAt(v.childCount - 1)
                    .measuredHeight - v.measuredHeight)) &&
                scrollY > oldScrollY
            ) {

                val mLayoutManager = recyclerView.layoutManager
                val visibleItemCount = mLayoutManager?.childCount ?: 0
                val totalItemCount = mLayoutManager?.itemCount ?: 0
                val pastVisibleItems = when (mLayoutManager) {
                    is GridLayoutManager -> mLayoutManager.findFirstVisibleItemPosition()
                    else -> (mLayoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
                }

                if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                    onLoadMore.invoke()
                }
            }
        }
    })
}