package com.cryptoapp.project_cryptoapp.presentation.onboarding

import androidx.lifecycle.ViewModel
import com.cryptoapp.project_cryptoapp.data.repository.user.UserRepository

class OnboardingViewModel(
    // private val prefRepository: PrefRepository,
    private val userRepository: UserRepository,
) : ViewModel() {
    /*fun isFirstRun() = prefRepository.isFirstRun()

    fun setFirstRun(isFirstRun: Boolean) = prefRepository.setFirstRun(isFirstRun)*/

    fun isLogin() = userRepository.isLoggedIn()
}
