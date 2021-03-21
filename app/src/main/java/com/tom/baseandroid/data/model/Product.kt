package com.tom.baseandroid.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 *Created by VanTrang on 8/22/2019.
 */
@Parcelize
data class DataProduct (
    @SerializedName("total_count")
    val totalCount: String? = null,
    @SerializedName("items")
    val products: MutableList<Product>? = null
) : Parcelable {
    @Parcelize
    data class Product(
        val name: String? = null,
        val image: String? = null
    ) : Parcelable
}
