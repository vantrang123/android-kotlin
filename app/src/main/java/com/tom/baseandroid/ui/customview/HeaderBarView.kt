package com.tom.baseandroid.ui.customview

import android.content.Context
import android.util.AttributeSet
import com.tom.baseandroid.R
import com.tom.baseandroid.base.BaseCustomView
import kotlinx.android.synthetic.main.view_header_bar.view.*

/**
 *Created by VanTrang.
 */
class HeaderBarView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyle: Int = 0
) : BaseCustomView(context, attrs, defStyle) {
    override fun getLayout(): Int = R.layout.view_header_bar

    fun onClick(event: (isKeyWord: Boolean) -> Unit) {
        root.setOnClickListener {
            event.invoke(true)
        }

        ivCamera.setOnClickListener {
            event.invoke(false)
        }
    }
}