package com.tom.baseandroid.base

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.annotation.StyleableRes
import androidx.constraintlayout.widget.ConstraintLayout

/**
 * Created by vantrang on 8/16/20.
 */
abstract class BaseCustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle) {
    var listener: ((Any) -> Unit)? = null
    var listenerSort: ((Any) -> Unit)? = null

    init {
        LayoutInflater.from(context).inflate(getLayout(), this.rootView as ViewGroup, true)
        onSetupView(attrs)
    }

    private fun onSetupView(attrs: AttributeSet?) {
        onCreatedView()
        try {
            if (attrs != null && getStyleable() != null) {
                val styleable = context.obtainStyledAttributes(attrs, getStyleable()!!, 0, 0)
                applyStyleable(styleable)
                styleable.recycle()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @LayoutRes
    abstract fun getLayout(): Int

    @StyleableRes
    open fun getStyleable(): IntArray? = null

    open fun onCreatedView() {}

    @SuppressLint("Recycle")
    open fun applyStyleable(styleable: TypedArray) {
    }

    open fun onSpecialClicked(listener: ((Any) -> Unit)?) {
        this.listener = listener
    }

    open fun onSortClicked(listener: ((Any) -> Unit)?) {
        this.listenerSort = listener
    }
}