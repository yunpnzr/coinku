package com.cryptoapp.project_cryptoapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.UUID

@Parcelize
data class Crypto(
    var id: String? = UUID.randomUUID().toString(),
    var ath: Double,
    var athChangePercentage: Double,
    var athDate: String,
    var atl: Double,
    var atlChangePercentage: Double,
    var circulatingSupply: Double,
    var currentPrice: Double,
    var fullyDilutedValuation: Long,
    var high24h: Double,
    var image: String,
    var lastUpdated: String,
    var low24h: Double,
    var marketCap: Long,
    var marketCapChange24h: Double,
    var marketCapChangePercentage24h: Double,
    var marketCapRank: Int,
    var maxSupply: Double,
    var name: String,
    var priceChange24h: Double,
    var priceChangePercentage24h: Double,
    var symbol: String,
    var totalSupply: Double,
    var totalVolume: Long
): Parcelable