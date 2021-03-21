package com.tom.baseandroid.utils

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageCircle")
fun loadImageCircle(img: AppCompatImageView, imagePath: String?) {
    Glide.with(img.context)
        .asBitmap()
        .load(imagePath)
        .circleCrop()
        .into(img)
}

@BindingAdapter("image")
fun loadImage(img: AppCompatImageView, imagePath: String?) {
    Glide.with(img.context)
        .asBitmap()
        .load(imagePath)
        .into(img)
}