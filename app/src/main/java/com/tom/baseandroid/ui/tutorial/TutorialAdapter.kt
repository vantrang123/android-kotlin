package com.tom.baseandroid.ui.tutorial

import android.view.View
import com.tom.baseandroid.R
import com.tom.baseandroid.data.model.Tutorial
import com.zhpan.bannerview.BaseBannerAdapter

/**
 *Created by VanTrang.
 */
class TutorialAdapter : BaseBannerAdapter<Tutorial, TutorialViewHolder>() {
    override fun onBind(holder: TutorialViewHolder, data: Tutorial, position: Int, pageSize: Int) {
        holder.bindData(data, position, pageSize)
    }

    override fun createViewHolder(itemView: View, viewType: Int): TutorialViewHolder {
        return TutorialViewHolder(itemView)
    }

    override fun getLayoutId(viewType: Int): Int = R.layout.item_tutorial_view
}