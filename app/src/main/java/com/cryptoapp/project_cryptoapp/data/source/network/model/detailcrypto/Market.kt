package com.cryptoapp.project_cryptoapp.data.source.network.model.detailcrypto

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Market(
    @SerializedName("has_trading_incentive")
    val hasTradingIncentive: Boolean?,
    @SerializedName("identifier")
    val identifier: String?,
    @SerializedName("name")
    val name: String?,
)
