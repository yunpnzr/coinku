package com.cryptoapp.project_cryptoapp.data.datasource.auth

import com.cryptoapp.project_cryptoapp.data.mapper.toUser
import com.cryptoapp.project_cryptoapp.data.model.User
import com.cryptoapp.project_cryptoapp.data.source.firebase.FirebaseServices

class FirebaseAuthDataSource(private val services: FirebaseServices) : AuthDataSource {
    override suspend fun doLogin(
        email: String,
        password: String,
    ): Boolean {
        return services.doLogin(email, password)
    }

    override suspend fun doRegister(
        name: String,
        email: String,
        password: String,
    ): Boolean {
        return services.doRegister(name, email, password)
    }

    override suspend fun updateProfile(name: String?): Boolean {
        return services.updateProfile(name)
    }

    override suspend fun updatePassword(newPassword: String): Boolean {
        return services.updatePassword(newPassword)
    }

    override fun requestChangePasswordByEmail(): Boolean {
        return services.requestChangePasswordByEmail()
    }

    override fun doLogout(): Boolean {
        return services.doLogout()
    }

    override fun isLoggedIn(): Boolean {
        return services.isLoggedIn()
    }

    override fun getCurrentUser(): User? {
        return services.getCurrentUser().toUser()
    }
}
