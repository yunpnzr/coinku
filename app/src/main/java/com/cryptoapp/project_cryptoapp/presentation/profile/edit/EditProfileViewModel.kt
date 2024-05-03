package com.cryptoapp.project_cryptoapp.presentation.profile.edit

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.cryptoapp.project_cryptoapp.data.model.User
import com.cryptoapp.project_cryptoapp.data.repository.user.UserRepository
import com.cryptoapp.project_cryptoapp.utils.ResultWrapper
import kotlinx.coroutines.Dispatchers

class EditProfileViewModel(
    private val userRepository: UserRepository,
) : ViewModel() {
    fun getCurrentUser(): User? {
        return userRepository.getCurrentUser()
    }

    fun doChangeProfile(name: String): LiveData<ResultWrapper<Boolean>> {
        return userRepository.updateProfile(name).asLiveData(Dispatchers.IO)
    }

    fun doChangePasswordByEmail(): Boolean {
        return userRepository.requestChangePassword()
    }
}
