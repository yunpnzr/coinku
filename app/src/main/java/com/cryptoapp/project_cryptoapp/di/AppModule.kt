package com.cryptoapp.project_cryptoapp.di

import com.cryptoapp.project_cryptoapp.data.datasource.auth.AuthDataSource
import com.cryptoapp.project_cryptoapp.data.datasource.auth.FirebaseAuthDataSource
import com.cryptoapp.project_cryptoapp.data.datasource.listcrypto.ListCryptoApiDataSource
import com.cryptoapp.project_cryptoapp.data.datasource.listcrypto.ListCryptoDataSource
import com.cryptoapp.project_cryptoapp.data.repository.listcrypto.ListCryptoRepository
import com.cryptoapp.project_cryptoapp.data.repository.listcrypto.ListCryptoRepositoryImpl
import com.cryptoapp.project_cryptoapp.data.repository.user.UserRepository
import com.cryptoapp.project_cryptoapp.data.repository.user.UserRepositoryImpl
import com.cryptoapp.project_cryptoapp.data.source.firebase.FirebaseServices
import com.cryptoapp.project_cryptoapp.data.source.firebase.FirebaseServicesImpl
import com.cryptoapp.project_cryptoapp.data.source.network.service.ApiService
import com.cryptoapp.project_cryptoapp.presentation.login.LoginViewModel
import com.cryptoapp.project_cryptoapp.presentation.main.MainViewModel
import com.cryptoapp.project_cryptoapp.presentation.register.RegisterViewModel
import com.google.firebase.auth.FirebaseAuth
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object AppModule {
    private val networkModule =
        module {
            single<ApiService> {
                ApiService.invoke()
            }
        }

    private val firebaseModule =
        module {
            single<FirebaseAuth> {
                FirebaseAuth.getInstance()
            }
            single<FirebaseServices> {
                FirebaseServicesImpl(get())
            }
        }

    private val dataSourceModule =
        module {
            single<AuthDataSource> {
                FirebaseAuthDataSource(get())
            }
            single<ListCryptoDataSource> {
                ListCryptoApiDataSource(get())
            }
        }

    private val repositoryModule =
        module {
            single<UserRepository> {
                UserRepositoryImpl(get())
            }
            single<ListCryptoRepository> {
                ListCryptoRepositoryImpl(get())
            }
        }

    private val viewModelModule =
        module {
            viewModel {
                MainViewModel(get())
            }
            viewModel {
                RegisterViewModel(get())
            }
            viewModel {
                LoginViewModel(get())
            }
        }

    val modules =
        listOf<Module>(
            networkModule,
            firebaseModule,
            dataSourceModule,
            repositoryModule,
            viewModelModule,
        )
}
