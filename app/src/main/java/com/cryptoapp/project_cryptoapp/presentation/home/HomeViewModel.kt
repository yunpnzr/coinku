package com.cryptoapp.project_cryptoapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.cryptoapp.project_cryptoapp.data.repository.listcrypto.ListCryptoRepository
import com.cryptoapp.project_cryptoapp.data.repository.user.UserRepository
import kotlinx.coroutines.Dispatchers

class HomeViewModel(
    private val listCryptoRepository: ListCryptoRepository,
    private val userRepository: UserRepository,
) : ViewModel() {
    fun getListCrypto(vsCurrency: String) = listCryptoRepository.getListCrypto(vsCurrency).asLiveData(Dispatchers.IO)

    fun getCurrentUser() = userRepository.getCurrentUser()

    fun isLoggedIn() = userRepository.isLoggedIn()
}
