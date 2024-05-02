package com.cryptoapp.project_cryptoapp.presentation.onboarding

import androidx.lifecycle.ViewModel
import com.cryptoapp.project_cryptoapp.data.repository.pref.PrefRepository

class OnboardingViewModel(
    private val prefRepository: PrefRepository
): ViewModel() {
    fun isFirstRun() = prefRepository.isFirstRun()
    fun setFirstRun(isFirstRun: Boolean) = prefRepository.setFirstRun(isFirstRun)
}