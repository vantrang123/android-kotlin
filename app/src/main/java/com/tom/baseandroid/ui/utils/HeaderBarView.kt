package com.tom.baseandroid.ui.utils

import android.content.Context
import android.util.AttributeSet
import com.tom.baseandroid.R
import com.tom.baseandroid.base.BaseCustomView

/**
 *Created by VanTrang.
 */
class HeaderBarView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyle: Int = 0
) : BaseCustomView(context, attrs, defStyle) {
    override fun getLayout(): Int = R.layout.view_header_bar


}