package com.cryptoapp.project_cryptoapp.data.repository.user

import com.cryptoapp.project_cryptoapp.data.model.User
import com.cryptoapp.project_cryptoapp.utils.ResultWrapper
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    @Throws(exceptionClasses = [Exception::class])
    fun doLogin(
        email: String,
        password: String,
    ): Flow<ResultWrapper<Boolean>>

    @Throws(exceptionClasses = [Exception::class])
    fun doRegister(
        name: String,
        email: String,
        password: String,
    ): Flow<ResultWrapper<Boolean>>

    fun updateProfile(name: String? = null): Flow<ResultWrapper<Boolean>>

    fun updatePassword(newPassword: String): Flow<ResultWrapper<Boolean>>

    fun requestChangePasswordByEmail(email: String): Flow<ResultWrapper<Boolean>>

    fun requestChangePassword(): Boolean

    fun doLogout(): Boolean

    fun isLoggedIn(): Boolean

    fun getCurrentUser(): User?
}
