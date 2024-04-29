package com.cryptoapp.project_cryptoapp.data.mapper

import com.cryptoapp.project_cryptoapp.data.model.Crypto
import com.cryptoapp.project_cryptoapp.data.source.network.model.listcrypto.ListCryptoResponseItem

fun ListCryptoResponseItem?.toCrypto() =
    Crypto(
        ath = this?.ath ?: 0.0,
        athChangePercentage = this?.athChangePercentage ?: 0.0,
        athDate = this?.athDate.orEmpty(),
        atl = this?.atl ?: 0.0,
        atlChangePercentage = this?.atlChangePercentage ?: 0.0,
        circulatingSupply = this?.circulatingSupply ?: 0.0,
        currentPrice = this?.currentPrice ?: 0.0,
        fullyDilutedValuation = this?.fullyDilutedValuation ?: 0L,
        high24h = this?.high24h ?: 0.0,
        image = this?.image.orEmpty(),
        lastUpdated = this?.lastUpdated.orEmpty(),
        low24h = this?.low24h ?: 0.0,
        marketCap = this?.marketCap ?: 0L,
        marketCapChange24h = this?.marketCapChange24h ?: 0.0,
        marketCapChangePercentage24h = this?.marketCapChangePercentage24h ?: 0.0,
        marketCapRank = this?.marketCapRank ?: 0,
        maxSupply = this?.maxSupply ?: 0.0,
        name = this?.name.orEmpty(),
        priceChange24h = this?.priceChange24h ?: 0.0,
        priceChangePercentage24h = this?.priceChangePercentage24h ?: 0.0,
        symbol = this?.symbol.orEmpty(),
        totalSupply = this?.totalSupply ?: 0.0,
        totalVolume = this?.totalVolume ?: 0L,
    )

fun Collection<ListCryptoResponseItem>?.toCryptos() = this?.map { it.toCrypto() } ?: listOf()
