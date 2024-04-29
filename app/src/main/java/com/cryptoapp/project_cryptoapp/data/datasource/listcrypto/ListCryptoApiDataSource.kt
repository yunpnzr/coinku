package com.cryptoapp.project_cryptoapp.data.datasource.listcrypto

import com.cryptoapp.project_cryptoapp.data.source.network.model.listcrypto.ListCryptoResponse
import com.cryptoapp.project_cryptoapp.data.source.network.service.ApiService

class ListCryptoApiDataSource(
    private val service: ApiService,
) : ListCryptoDataSource {
    override suspend fun getListCrypto(vsCurrency: String): ListCryptoResponse {
        return service.getCrypto(vsCurrency)
    }
}
