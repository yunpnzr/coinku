package com.cryptoapp.project_cryptoapp.data.datasource.listcrypto

import com.cryptoapp.project_cryptoapp.data.source.network.model.listcrypto.ListCryptoResponse

interface ListCryptoDataSource {
    suspend fun getListCrypto(vsCurrency: String): ListCryptoResponse
}
