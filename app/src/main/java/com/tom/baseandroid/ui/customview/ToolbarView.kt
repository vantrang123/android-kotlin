package com.tom.baseandroid.ui.customview

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import com.tom.baseandroid.R
import com.tom.baseandroid.base.BaseCustomView
import kotlinx.android.synthetic.main.view_toolbar.view.*

/**
 * Created by vantrang on 8/16/20.
 */
class ToolbarView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : BaseCustomView(context, attrs, defStyle) {
    override fun getLayout(): Int = R.layout.view_toolbar

    override fun getStyleable(): IntArray? = R.styleable.TopbarView

    fun onBackPressed(event: () -> Unit) {
        btBack.setOnClickListener {
            event.invoke()
        }
    }

    override fun applyStyleable(styleable: TypedArray) {
        val title = styleable.getString(R.styleable.TopbarView_toolbar_title_tv)
        setTitle(title)
        val drawableBack = styleable.getDrawable(R.styleable.TopbarView_toolbar_drawable_back)
        btBack.setImageDrawable(drawableBack)
    }

    fun setTitle(title: String? = "") {
        tvTitle?.apply {
            text = title
        }
    }
}