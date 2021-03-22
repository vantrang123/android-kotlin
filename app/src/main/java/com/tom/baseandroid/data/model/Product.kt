package com.tom.baseandroid.data.model

import android.content.Context
import android.os.Parcelable
import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName
import com.tom.baseandroid.R
import com.tom.baseandroid.utils.Constants.CURRENCY_VND
import com.tom.baseandroid.utils.Utils
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

/**
 *Created by VanTrang on 8/22/2019.
 */
@Parcelize
data class DataProduct(
    @SerializedName("total_count")
    val totalCount: String? = null,
    @SerializedName("items")
    val products: MutableList<Product>? = null
) : Parcelable {
    @Parcelize
    data class Product(

        val discount: String? = null,

        val sold: Long? = null,
//        val stock: Long? = null,

//        @SerializedName("price_max")
//        val priceMax: Long? = null,
//
//
        @SerializedName("historical_sold")
        val historicalSold: Long? = null,
//
//        @SerializedName("is_category_failed")
//        val isCategoryFailed: Boolean? = null,
//
//
//        @SerializedName("item_rating")
//        val itemRating: ItemRating? = null,
//
//        @SerializedName("has_lowest_price_guarantee")
//        val hasLowestPriceGuarantee: Boolean? = null,
//
//        @SerializedName("is_adult")
//        val isAdult: Boolean? = null,
//
//        @SerializedName("shop_id")
//        val shopID: Long? = null,
//
//        @SerializedName("tracking_info")
//        val trackingInfo: TrackingInfo? = null,
//
//        val brand: String? = null,
//
//        @SerializedName("reference_item_id")
//        val referenceItemID: String? = null,
//
//        @SerializedName("shop_location")
//        val shopLocation: String? = null,
//
//        @SerializedName("price_min")
//        val priceMin: Long? = null,
//
//        @SerializedName("cb_option")
//        val cbOption: Long? = null,
//
//        @SerializedName("is_non_cc_installment_payment_eligible")
//        val isNonCcInstallmentPaymentEligible: Boolean? = null,
//
//        @SerializedName("liked_count")
//        val likedCount: Long? = null,
//
//        @SerializedName("can_use_wholesale")
//        val canUseWholesale: Boolean? = null,
//
//        val currency: String? = null,
//
//        @SerializedName("category_id")
//        val categoryID: Long? = null,
//
//        @SerializedName("price_before_discount")
//        val priceBeforeDiscount: Long? = null,
//
//        @SerializedName("raw_discount")
//        val rawDiscount: Long? = null,
//
//        @SerializedName("cmt_count")
//        val cmtCount: Long? = null,
//
//        val flag: Long? = null,
//
//        @SerializedName("price_min_before_discount")
//        val priceMinBeforeDiscount: Long? = null,
//
//        @SerializedName("is_preferred_plus_seller")
//        val isPreferredPlusSeller: Boolean? = null,
//
        val image: String? = null,
//
//        @SerializedName("can_use_bundle_deal")
//        val canUseBundleDeal: Boolean? = null,
//
//        @SerializedName("price_max_before_discount")
//        val priceMaxBeforeDiscount: Long? = null,
//
//        val status: Long? = null,
//
//        @SerializedName("shopee_verified")
//        val shopeeVerified: Boolean? = null,
//
        val price: Long? = null,
//
//        @SerializedName("is_official_shop")
//        val isOfficialShop: Boolean? = null,
//
//        val ctime: Long? = null,
//
//        @SerializedName("item_status")
//        val itemStatus: String? = null,
//
//        @SerializedName("item_id")
//        val itemID: Long? = null,
//
        val name: String? = null,
//
//        @SerializedName("tier_variations")
//        val tierVariations: List<TierVariation>? = null,
//
//        @SerializedName("item_type")
//        val itemType: Long? = null,
//
//        @SerializedName("badge_icon_type")
//        val badgeIconType: Long? = null
    ) : Parcelable {
//        @Parcelize
//        data class ItemRating(
//            @SerializedName("rating_with_image")
//            val ratingWithImage: Long? = null,
//
//            @SerializedName("rating_with_context")
//            val ratingWithContext: Long? = null,
//
//            @SerializedName("rating_star")
//            val ratingStar: Double? = null,
//
//            @SerializedName("rating_5_star")
//            val rating5_Star: Long? = null,
//
//            @SerializedName("rating_4_star")
//            val rating4_Star: Long? = null,
//
//            @SerializedName("rating_1_star")
//            val rating1_Star: Long? = null,
//
//            @SerializedName("rating_total")
//            val ratingTotal: Long? = null,
//
//            @SerializedName("rating_3_star")
//            val rating3_Star: Long? = null,
//
//
//            @SerializedName("rating_2_star")
//            val rating2_Star: Long? = null
//        ) : Parcelable
//
//        @Parcelize
//        data class TierVariation(
//            val options: List<String>? = null,
//            val images: List<String>? = null,
//            val name: String? = null,
//            val type: Long? = null
//        ) : Parcelable
//
//        @Parcelize
//        data class TrackingInfo(
//            @SerializedName("multi_search_tracking")
//            val multiSearchTracking: List<Long>? = null,
//
//            @SerializedName("groupid")
//            val groupId: Long? = null,
//
//            @SerializedName("groupid")
//            val ruleId: List<Long>? = null,
//
//        ) : Parcelable

        fun priceWithCurrency() = Utils.spanSize(CURRENCY_VND, price.toString())
//
        fun sold(context: Context) = context.getString(R.string.sold).plus(" $historicalSold")
    }
}
