package com.cryptoapp.project_cryptoapp.presentation.profile

import androidx.lifecycle.ViewModel
import com.cryptoapp.project_cryptoapp.data.model.User
import com.cryptoapp.project_cryptoapp.data.repository.user.UserRepository

class ProfileViewModel(
    private val userRepository: UserRepository,
) : ViewModel() {
    fun doLogout(): Boolean {
        return userRepository.doLogout()
    }

    fun getCurrentUser(): User? {
        return userRepository.getCurrentUser()
    }
}
