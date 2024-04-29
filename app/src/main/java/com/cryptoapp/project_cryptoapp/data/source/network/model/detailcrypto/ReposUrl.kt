package com.cryptoapp.project_cryptoapp.data.source.network.model.detailcrypto


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ReposUrl(
    @SerializedName("bitbucket")
    val bitbucket: List<Any?>?,
    @SerializedName("github")
    val github: List<String?>?
)