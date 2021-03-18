package com.tom.baseandroid.ui.home

import android.view.View
import com.bumptech.glide.Glide
import com.tom.baseandroid.R
import com.tom.baseandroid.data.model.Banner
import com.tom.baseandroid.extensions.getDefault
import com.zhpan.bannerview.BaseViewHolder
import kotlinx.android.synthetic.main.item_banner.view.*

/**
 *Created by VanTrang.
 */
class BannerViewHolder(view: View) : BaseViewHolder<Banner>(view) {
    private var mOnSubViewClickListener: OnSubViewClickListener? = null

    override fun bindData(data: Banner, position: Int, pageSize: Int) {
        with(itemView) {
            Glide.with(context)
                .load(data.imgUrl.getDefault())
                .placeholder(R.color.gray_chalice)
                .error(R.color.gray_chalice)
                .into(ivBanner)

            setOnClickListener {
                if (null != mOnSubViewClickListener)
                    mOnSubViewClickListener!!.onViewClick(position)
            }
        }
    }

    fun setOnSubViewClickListener(subViewClickListener: OnSubViewClickListener?) {
        mOnSubViewClickListener = subViewClickListener
    }

    interface OnSubViewClickListener {
        fun onViewClick(position: Int)
    }
}