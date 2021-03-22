package com.tom.baseandroid.ui.utils

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.GridLayoutManager
import com.tom.baseandroid.R
import com.tom.baseandroid.base.BaseCustomView
import com.tom.baseandroid.data.model.DataCategory
import com.tom.baseandroid.data.model.DataProduct
import com.tom.baseandroid.data.model.HomeGroup
import com.tom.baseandroid.ui.home.CategoryAdapter
import com.tom.baseandroid.ui.home.ProductAdapter
import kotlinx.android.synthetic.main.view_group_home.view.*

/**
 *Created by VanTrang.
 */
class GroupHomeView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : BaseCustomView(context, attrs, defStyle) {
    private var mCategoryAdapter: CategoryAdapter? = null
    private var mProductAdapter: ProductAdapter? = null

    override fun getLayout(): Int = R.layout.view_group_home

    fun initView(type: HomeGroup) {
        when (type) {
            HomeGroup.CATEGORY -> {
                rvData.apply {
                    layoutManager =
                        GridLayoutManager(context, 2, GridLayoutManager.HORIZONTAL, false)
                    mCategoryAdapter = CategoryAdapter()
                    adapter = mCategoryAdapter
                }
                tvName.text = context.getString(R.string.category)
            }
            HomeGroup.SUGGESTION -> {
                rvData.apply {
                    layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
                    mProductAdapter = ProductAdapter()
                    adapter = mProductAdapter
                }
                tvName.text = context.getString(R.string.suggestion)
            }
        }
    }

    fun onDataChange(data: MutableList<*>, type: HomeGroup) {
        when (type) {
            HomeGroup.CATEGORY -> {
                mCategoryAdapter?.updateData(data as MutableList<DataCategory.Category>)
            }
            HomeGroup.SUGGESTION -> {
                mProductAdapter?.updateData(data as MutableList<DataProduct.Product>)
            }
        }
    }
}