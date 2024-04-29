package com.cryptoapp.project_cryptoapp.data.source.network.model.detailcrypto

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class X(
    @SerializedName("contract_address")
    val contractAddress: String?,
    @SerializedName("decimal_place")
    val decimalPlace: Any?,
)
