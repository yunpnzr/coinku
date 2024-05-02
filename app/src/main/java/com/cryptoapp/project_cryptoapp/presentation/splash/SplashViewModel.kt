package com.cryptoapp.project_cryptoapp.presentation.splash

import androidx.lifecycle.ViewModel
import com.cryptoapp.project_cryptoapp.data.repository.user.UserRepository

class SplashViewModel(private val userRepository: UserRepository) : ViewModel() {
    fun isLogin() = userRepository.isLoggedIn()
}
