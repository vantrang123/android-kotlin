package com.tom.baseandroid.ui.tutorial

import android.animation.ObjectAnimator
import android.view.View
import com.tom.baseandroid.R
import com.tom.baseandroid.data.model.Tutorial
import com.zhpan.bannerview.holder.ViewHolder
import kotlinx.android.synthetic.main.item_tutorial.view.*

class TutorialViewHolder : ViewHolder<Tutorial> {
    override fun getLayoutId(): Int = R.layout.item_tutorial

    override fun onBind(itemView: View?, data: Tutorial?, position: Int, size: Int) {
        itemView?.apply {
            banner_image.setImageResource(data?.imageRes ?: R.color.blue_light)
            val alphaAnimator = ObjectAnimator.ofFloat(banner_image, "alpha", 0f, 1f)
            alphaAnimator.duration = 1500
            alphaAnimator.start()
        }
    }
}