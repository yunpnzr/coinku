package com.cryptoapp.project_cryptoapp.data.datasource.auth

import com.cryptoapp.project_cryptoapp.data.model.User

interface AuthDataSource {

    @Throws(exceptionClasses = [Exception::class])
    suspend fun doLogin(
        email: String,
        password: String,
    ): Boolean

    @Throws(exceptionClasses = [Exception::class])
    suspend fun doRegister(
        name: String,
        email: String,
        password: String,
    ): Boolean

    suspend fun updateProfile(name: String? = null): Boolean

    suspend fun updatePassword(newPassword: String): Boolean

    fun requestChangePasswordByEmail(): Boolean

    fun doLogout(): Boolean

    fun isLoggedIn(): Boolean

    fun getCurrentUser(): User?
}