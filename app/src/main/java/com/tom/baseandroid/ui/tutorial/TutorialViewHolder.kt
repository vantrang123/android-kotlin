package com.tom.baseandroid.ui.tutorial

import android.animation.ObjectAnimator
import android.view.View
import com.tom.baseandroid.R
import com.tom.baseandroid.data.model.Tutorial
import com.zhpan.bannerview.BaseViewHolder
import kotlinx.android.synthetic.main.item_tutorial_view.view.*

class TutorialViewHolder(view: View) : BaseViewHolder<Tutorial>(view) {

    override fun bindData(data: Tutorial, position: Int, pageSize: Int) {
        with(itemView) {
            banner_image.setImageResource(data.imageRes ?: R.color.blue_light)
            val alphaAnimator = ObjectAnimator.ofFloat(banner_image, "alpha", 0f, 1f)
            alphaAnimator.duration = 1500
            alphaAnimator.start()
        }
    }




}