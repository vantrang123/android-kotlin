package com.tom.baseandroid.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 *Created by VanTrang on 8/22/2019.
 */
@Parcelize
class Product(
    val name: String? = null
) : Parcelable {

}