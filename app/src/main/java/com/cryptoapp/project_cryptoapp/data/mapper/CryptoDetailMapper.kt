package com.cryptoapp.project_cryptoapp.data.mapper

import com.cryptoapp.project_cryptoapp.data.model.CryptoDetail
import com.cryptoapp.project_cryptoapp.data.source.network.model.detailcrypto.DetailCryptoResponse

fun DetailCryptoResponse?.toCryptoDetail() =
    CryptoDetail(
        id = this?.id.orEmpty(),
        name = this?.name.orEmpty(),
        price = this?.marketData?.currentPrice?.idr ?: 0.0,
        image = this?.image?.large.orEmpty(),
        description = this?.description?.en.orEmpty(),
    )
