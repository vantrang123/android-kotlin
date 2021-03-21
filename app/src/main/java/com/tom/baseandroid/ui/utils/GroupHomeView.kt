package com.tom.baseandroid.ui.utils

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.GridLayoutManager
import com.tom.baseandroid.R
import com.tom.baseandroid.base.BaseCustomView
import com.tom.baseandroid.data.model.Data
import com.tom.baseandroid.ui.home.CategoryAdapter
import kotlinx.android.synthetic.main.view_list_category.view.*

/**
 *Created by VanTrang.
 */
class GroupHomeView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : BaseCustomView(context, attrs, defStyle) {
    private var mCategoryAdapter: CategoryAdapter? = null

    override fun getLayout(): Int = R.layout.view_list_category

    fun initView() {
        rvData.apply {
            layoutManager = GridLayoutManager(context, 2, GridLayoutManager.HORIZONTAL, false)
            mCategoryAdapter = CategoryAdapter()
            adapter = mCategoryAdapter
        }
        tvName.text = context.getString(R.string.category)
    }

    fun onDataChange(data: MutableList<Data.Category>) {
        mCategoryAdapter?.updateData(data)
    }
}