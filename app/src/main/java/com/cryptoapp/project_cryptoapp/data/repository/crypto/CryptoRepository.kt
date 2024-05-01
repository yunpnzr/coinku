package com.cryptoapp.project_cryptoapp.data.repository.crypto

import com.cryptoapp.project_cryptoapp.data.datasource.crypto.CryptoDataSource
import com.cryptoapp.project_cryptoapp.data.mapper.toCryptoDetail
import com.cryptoapp.project_cryptoapp.data.model.CryptoDetail
import com.cryptoapp.project_cryptoapp.utils.ResultWrapper
import com.cryptoapp.project_cryptoapp.utils.proceedFlow
import kotlinx.coroutines.flow.Flow

interface CryptoRepository {
    fun getCryptoDetail(id: String): Flow<ResultWrapper<CryptoDetail>>
}

class CryptoRepositoryImpl(
    private val dataSource: CryptoDataSource,
) : CryptoRepository {
    override fun getCryptoDetail(id: String): Flow<ResultWrapper<CryptoDetail>> {
        return proceedFlow {
            dataSource.getCryptoDetail(id).toCryptoDetail()
        }
    }
}
