package com.cryptoapp.project_cryptoapp.data.source.network.model.detailcrypto


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Image(
    @SerializedName("large")
    val large: String?,
    @SerializedName("small")
    val small: String?,
    @SerializedName("thumb")
    val thumb: String?
)