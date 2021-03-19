package com.tom.baseandroid.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 *Created by VanTrang.
 */

@Parcelize
data class Data(
        val categories: MutableList<Category>? = null
) : Parcelable {
    @Parcelize
    data class Category(
            val main: Main? = null
    ) : Parcelable {
        @Parcelize
        data class Main(
                @SerializedName("category_display_name")
                val categoryDisplayName: String,

                @SerializedName("is_adult")
                val isAdult: Long,

                @SerializedName("category_id")
                val categoryID: Long,

                @SerializedName("category_name")
                val categoryName: String,

                @SerializedName("parent_category")
                val parentCategory: Long,

                @SerializedName("category_image")
                val imageUrl: String? = null
        ) : Parcelable
    }
}