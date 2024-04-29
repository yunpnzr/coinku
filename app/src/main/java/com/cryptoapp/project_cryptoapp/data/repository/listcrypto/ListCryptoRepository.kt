package com.cryptoapp.project_cryptoapp.data.repository.listcrypto

import com.cryptoapp.project_cryptoapp.data.model.Crypto
import com.cryptoapp.project_cryptoapp.utils.ResultWrapper
import kotlinx.coroutines.flow.Flow

interface ListCryptoRepository {
    fun getListCrypto(vsCurrency: String): Flow<ResultWrapper<List<Crypto>>>
}