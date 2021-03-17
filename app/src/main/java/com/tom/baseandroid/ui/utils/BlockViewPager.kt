package com.tom.baseandroid.ui.utils

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

/**
 *Created by VanTrang on 8/22/2019.
 */
class BlockViewPager @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null
) : ViewPager(context, attrs) {
    private var isEnable: Boolean = true

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return if (isEnable) {
            super.onTouchEvent(ev)
        } else false
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return if (isEnable) {
            super.onInterceptTouchEvent(ev)
        } else false
    }

    fun setPagingEnable(isEnable: Boolean) {
        this.isEnable = isEnable
    }
}