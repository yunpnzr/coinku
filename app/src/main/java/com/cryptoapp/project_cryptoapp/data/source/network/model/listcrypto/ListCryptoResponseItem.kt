package com.cryptoapp.project_cryptoapp.data.source.network.model.listcrypto

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ListCryptoResponseItem(
    @SerializedName("current_price")
    val currentPrice: Double?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("symbol")
    val symbol: String?,
)
