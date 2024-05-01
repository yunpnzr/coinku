package com.cryptoapp.project_cryptoapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.UUID

@Parcelize
data class Crypto(
    var id: String? = UUID.randomUUID().toString(),
    var currentPrice: Double,
    var image: String,
    var name: String,
    var symbol: String,
) : Parcelable
