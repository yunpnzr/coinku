package com.cryptoapp.project_cryptoapp.data.datasource.crypto

import com.cryptoapp.project_cryptoapp.data.source.network.model.detailcrypto.DetailCryptoResponse

interface CryptoDataSource {
    suspend fun getCryptoDetail(id: String): DetailCryptoResponse
}
