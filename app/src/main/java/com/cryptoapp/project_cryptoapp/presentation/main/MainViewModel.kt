package com.cryptoapp.project_cryptoapp.presentation.main

import androidx.lifecycle.ViewModel
import com.cryptoapp.project_cryptoapp.data.repository.listcrypto.ListCryptoRepository
import com.cryptoapp.project_cryptoapp.data.repository.user.UserRepository

class MainViewModel(
    private val listCryptoRepository: ListCryptoRepository,
    private val userRepository: UserRepository,
) : ViewModel() {
    fun isLoggedIn(): Boolean {
        return userRepository.isLoggedIn()
    }
}
