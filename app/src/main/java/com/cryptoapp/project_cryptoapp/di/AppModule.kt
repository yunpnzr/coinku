package com.cryptoapp.project_cryptoapp.di

import com.cryptoapp.project_cryptoapp.data.datasource.auth.AuthDataSource
import com.cryptoapp.project_cryptoapp.data.datasource.auth.FirebaseAuthDataSource
import com.cryptoapp.project_cryptoapp.data.datasource.crypto.CryptoApiDataSource
import com.cryptoapp.project_cryptoapp.data.datasource.crypto.CryptoDataSource
import com.cryptoapp.project_cryptoapp.data.datasource.listcrypto.ListCryptoApiDataSource
import com.cryptoapp.project_cryptoapp.data.datasource.listcrypto.ListCryptoDataSource
import com.cryptoapp.project_cryptoapp.data.repository.crypto.CryptoRepository
import com.cryptoapp.project_cryptoapp.data.repository.crypto.CryptoRepositoryImpl
import com.cryptoapp.project_cryptoapp.data.repository.listcrypto.ListCryptoRepository
import com.cryptoapp.project_cryptoapp.data.repository.listcrypto.ListCryptoRepositoryImpl
import com.cryptoapp.project_cryptoapp.data.repository.user.UserRepository
import com.cryptoapp.project_cryptoapp.data.repository.user.UserRepositoryImpl
import com.cryptoapp.project_cryptoapp.data.source.firebase.FirebaseServices
import com.cryptoapp.project_cryptoapp.data.source.firebase.FirebaseServicesImpl
import com.cryptoapp.project_cryptoapp.data.source.network.service.ApiService
import com.cryptoapp.project_cryptoapp.presentation.detailcrypto.DetailCryptoViewModel
import com.cryptoapp.project_cryptoapp.presentation.home.HomeViewModel
import com.cryptoapp.project_cryptoapp.presentation.login.LoginViewModel
import com.cryptoapp.project_cryptoapp.presentation.main.MainViewModel
import com.cryptoapp.project_cryptoapp.presentation.register.RegisterViewModel
import com.google.firebase.auth.FirebaseAuth
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
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
            single<CryptoDataSource> {
                CryptoApiDataSource(get())
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
            single<CryptoRepository> {
                CryptoRepositoryImpl(get())
            }
        }

    private val viewModelModule =
        module {
            viewModelOf(::MainViewModel)
            viewModelOf(::HomeViewModel)
            viewModelOf(::RegisterViewModel)
            viewModelOf(::LoginViewModel)
            viewModel { params ->
                DetailCryptoViewModel(
                    intent = params.get(),
                    cryptoRepository = get(),
                )
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
