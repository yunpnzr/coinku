package com.cryptoapp.project_cryptoapp.data.source.network.model.listcrypto

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Roi(
    @SerializedName("currency")
    val currency: String?,
    @SerializedName("percentage")
    val percentage: Double?,
    @SerializedName("times")
    val times: Double?,
)
