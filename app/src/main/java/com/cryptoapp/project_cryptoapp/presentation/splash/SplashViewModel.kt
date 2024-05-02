package com.cryptoapp.project_cryptoapp.presentation.splash

import androidx.lifecycle.ViewModel
import com.cryptoapp.project_cryptoapp.data.repository.pref.PrefRepository
import com.cryptoapp.project_cryptoapp.data.repository.user.UserRepository

class SplashViewModel(
    private val userRepository: UserRepository,
    private val prefRepository: PrefRepository,
) : ViewModel() {
    fun isLogin() = userRepository.isLoggedIn()

    fun isFirstRun() = prefRepository.isFirstRun()

    fun setFirstRun(isFirstRun: Boolean) = prefRepository.setFirstRun(isFirstRun)
}
