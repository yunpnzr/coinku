package com.cryptoapp.project_cryptoapp.data.source.network.model.detailcrypto


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ConvertedVolume(
    @SerializedName("btc")
    val btc: Double?,
    @SerializedName("eth")
    val eth: Double?,
    @SerializedName("usd")
    val usd: Long?
)