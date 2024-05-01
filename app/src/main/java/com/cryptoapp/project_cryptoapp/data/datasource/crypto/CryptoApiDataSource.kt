package com.cryptoapp.project_cryptoapp.data.datasource.crypto

import com.cryptoapp.project_cryptoapp.data.source.network.model.detailcrypto.DetailCryptoResponse
import com.cryptoapp.project_cryptoapp.data.source.network.service.ApiService

class CryptoApiDataSource(
    private val service: ApiService,
) : CryptoDataSource {
    override suspend fun getCryptoDetail(id: String): DetailCryptoResponse {
        return service.getDetail(id)
    }
}
