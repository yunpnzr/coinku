package com.cryptoapp.project_cryptoapp.data.repository.user

import com.cryptoapp.project_cryptoapp.data.datasource.auth.AuthDataSource
import com.cryptoapp.project_cryptoapp.data.model.User
import com.cryptoapp.project_cryptoapp.utils.ResultWrapper
import com.cryptoapp.project_cryptoapp.utils.proceedFlow
import kotlinx.coroutines.flow.Flow

class UserRepositoryImpl(private val dataSource: AuthDataSource) : UserRepository {
    override fun doLogin(
        email: String,
        password: String,
    ): Flow<ResultWrapper<Boolean>> {
        return proceedFlow {
            dataSource.doLogin(email, password)
        }
    }

    override fun doRegister(
        name: String,
        email: String,
        password: String,
    ): Flow<ResultWrapper<Boolean>> {
        return proceedFlow {
            dataSource.doRegister(name, email, password)
        }
    }

    override fun updateProfile(name: String?): Flow<ResultWrapper<Boolean>> {
        return proceedFlow {
            dataSource.updateProfile(name)
        }
    }

    override fun updatePassword(newPassword: String): Flow<ResultWrapper<Boolean>> {
        return proceedFlow {
            dataSource.updatePassword(newPassword)
        }
    }

    override fun requestChangePasswordByEmail(): Boolean {
        return dataSource.requestChangePasswordByEmail()
    }

    override fun doLogout(): Boolean {
        return dataSource.doLogout()
    }

    override fun isLoggedIn(): Boolean {
        return dataSource.isLoggedIn()
    }

    override fun getCurrentUser(): User? {
        return dataSource.getCurrentUser()
    }
}
