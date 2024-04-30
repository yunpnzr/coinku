package com.cryptoapp.project_cryptoapp.presentation.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.cryptoapp.project_cryptoapp.data.repository.user.UserRepository
import com.cryptoapp.project_cryptoapp.utils.ResultWrapper
import kotlinx.coroutines.Dispatchers

class RegisterViewModel(private val userRepository: UserRepository) : ViewModel() {
    fun doRegister(
        name: String,
        email: String,
        password: String,
    ): LiveData<ResultWrapper<Boolean>> {
        return userRepository.doRegister(name, email, password).asLiveData(Dispatchers.IO)
    }
}
