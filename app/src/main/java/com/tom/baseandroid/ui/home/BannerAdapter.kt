package com.tom.baseandroid.ui.home

import android.view.View
import com.tom.baseandroid.R
import com.tom.baseandroid.data.model.Banner
import com.zhpan.bannerview.BaseBannerAdapter

/**
 *Created by VanTrang.
 */
class BannerAdapter : BaseBannerAdapter<Banner, BannerViewHolder>() {
    var mOnSubViewClickListener: BannerViewHolder.OnSubViewClickListener? = null
    override fun onBind(holder: BannerViewHolder, data: Banner, position: Int, pageSize: Int) {
        holder.bindData(data, position, pageSize)
    }

    override fun createViewHolder(itemView: View, viewType: Int): BannerViewHolder {
        return BannerViewHolder(itemView).apply { setOnSubViewClickListener(mOnSubViewClickListener) }
    }

    override fun getLayoutId(viewType: Int): Int = R.layout.item_banner
}