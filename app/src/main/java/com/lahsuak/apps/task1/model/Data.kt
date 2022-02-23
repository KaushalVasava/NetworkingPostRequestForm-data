package com.lahsuak.apps.task1.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.gson.annotations.SerializedName


data class Results(@SerializedName("results") val results: Data)
data class Data(@SerializedName("data") val details: List<Details>)
data class Details(
    @SerializedName("company_id") val companyId: Int,
    @SerializedName("company_name") val companyName: String,
    @SerializedName("company_logo") val companyImage: String
) {
    companion object {
        @JvmStatic
        @BindingAdapter("android:loadImage")
        fun loadImage(imageView: ImageView, imageUrl: String) {
//            val requestOptions = RequestOptions().transform(CenterCrop(), RoundedCorners(16))

            Glide.with(imageView).load(imageUrl)
//                .apply(requestOptions)
                .into(imageView)
        }
    }
}