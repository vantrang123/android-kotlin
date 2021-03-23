package com.tom.baseandroid.ui.customview

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import com.tom.baseandroid.R
import com.tom.baseandroid.base.BaseCustomView
import kotlinx.android.synthetic.main.view_searchbar.view.btBack

class SearchBarView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : BaseCustomView(context, attrs, defStyle) {
    override fun getLayout(): Int = R.layout.view_searchbar

    override fun getStyleable(): IntArray? = R.styleable.SearchBarView

    override fun applyStyleable(styleable: TypedArray) {
        val drawableBack = styleable.getDrawable(R.styleable.SearchBarView_search_bar_drawable_back)
        btBack.setImageDrawable(drawableBack)
    }

    fun onBackPressed(event: () -> Unit) {
        btBack.setOnClickListener {
            event.invoke()
        }
    }

}