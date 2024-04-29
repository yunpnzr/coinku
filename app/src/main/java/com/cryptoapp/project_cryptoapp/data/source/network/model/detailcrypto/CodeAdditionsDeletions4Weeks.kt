package com.cryptoapp.project_cryptoapp.data.source.network.model.detailcrypto


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class CodeAdditionsDeletions4Weeks(
    @SerializedName("additions")
    val additions: Int?,
    @SerializedName("deletions")
    val deletions: Int?
)