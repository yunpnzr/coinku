package com.cryptoapp.project_cryptoapp.data.mapper

import com.cryptoapp.project_cryptoapp.data.model.Crypto
import com.cryptoapp.project_cryptoapp.data.source.network.model.listcrypto.ListCryptoResponseItem

fun ListCryptoResponseItem?.toCrypto() =
    Crypto(
        id = this?.id.orEmpty(),
        currentPrice = this?.currentPrice ?: 0.0,
        image = this?.image.orEmpty(),
        name = this?.name.orEmpty(),
        symbol = this?.symbol.orEmpty(),
    )

fun Collection<ListCryptoResponseItem>?.toCryptos() = this?.map { it.toCrypto() } ?: listOf()
