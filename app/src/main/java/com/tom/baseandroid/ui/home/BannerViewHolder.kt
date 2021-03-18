package com.tom.baseandroid.ui.home

import android.view.View
import com.bumptech.glide.Glide
import com.tom.baseandroid.R
import com.tom.baseandroid.data.model.Banner
import com.tom.baseandroid.extensions.getDefault
import com.zhpan.bannerview.holder.ViewHolder
import kotlinx.android.synthetic.main.item_banner.view.*

/**
 *Created by VanTrang.
 */
class BannerViewHolder : ViewHolder<Banner> {
    private var mOnSubViewClickListener: OnSubViewClickListener? = null

    fun setOnSubViewClickListener(subViewClickListener: OnSubViewClickListener?) {
        mOnSubViewClickListener = subViewClickListener
    }

    interface OnSubViewClickListener {
        fun onViewClick(position: Int)
    }

    override fun getLayoutId(): Int = R.layout.item_banner

    override fun onBind(itemView: View, data: Banner, position: Int, size: Int) {
        with(itemView) {
            Glide.with(context)
                .load(data.imageRes.getDefault())
                .placeholder(R.color.gray_chalice)
                .error(R.color.gray_chalice)
                .into(ivBanner)

            setOnClickListener {
                if (null != mOnSubViewClickListener)
                    mOnSubViewClickListener!!.onViewClick(position)
            }
        }
    }
}