package com.cryptoapp.project_cryptoapp.data.source.network.model.detailcrypto

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class DetailCryptoResponse(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("market_data")
    val marketData: MarketData?,
    @SerializedName("image")
    val image: Image?,
    @SerializedName("description")
    val description: Description?,
)
