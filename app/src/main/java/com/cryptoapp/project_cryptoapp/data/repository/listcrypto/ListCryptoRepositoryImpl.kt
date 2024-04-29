package com.cryptoapp.project_cryptoapp.data.repository.listcrypto

import com.cryptoapp.project_cryptoapp.data.datasource.listcrypto.ListCryptoDataSource
import com.cryptoapp.project_cryptoapp.data.mapper.toCryptos
import com.cryptoapp.project_cryptoapp.data.model.Crypto
import com.cryptoapp.project_cryptoapp.utils.ResultWrapper
import com.cryptoapp.project_cryptoapp.utils.proceedFlow
import kotlinx.coroutines.flow.Flow

class ListCryptoRepositoryImpl(private val dataSource: ListCryptoDataSource): ListCryptoRepository {
    override fun getListCrypto(vsCurrency: String): Flow<ResultWrapper<List<Crypto>>> {
        return proceedFlow {
            dataSource.getListCrypto(vsCurrency).toCryptos()
        }
    }
}