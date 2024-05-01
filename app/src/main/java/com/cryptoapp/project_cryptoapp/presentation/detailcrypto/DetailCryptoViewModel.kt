package com.cryptoapp.project_cryptoapp.presentation.detailcrypto

import android.content.Intent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.cryptoapp.project_cryptoapp.data.repository.crypto.CryptoRepository
import kotlinx.coroutines.Dispatchers

class DetailCryptoViewModel(
    intent: Intent,
    private val cryptoRepository: CryptoRepository,
) : ViewModel() {
    val id: String? = intent.getStringExtra(DetailCryptoActivity.ID_COIN)

    val link: String = "https://www.coingecko.com/en/coins/$id"

    fun getDetailCrypto(id: String) = cryptoRepository.getCryptoDetail(id).asLiveData(Dispatchers.IO)
}
