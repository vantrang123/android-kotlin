package com.rikai.baseandroid.utils

import android.content.Context
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("image")
fun loadImage(img: AppCompatImageView, imagePath: String?) {
    Glide.with(img.context)
        .asBitmap()
        .load(imagePath)
        .circleCrop()
        .into(img)
}