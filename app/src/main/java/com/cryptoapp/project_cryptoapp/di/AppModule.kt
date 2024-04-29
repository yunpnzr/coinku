package com.cryptoapp.project_cryptoapp.di

import com.cryptoapp.project_cryptoapp.data.source.firebase.FirebaseServices
import com.cryptoapp.project_cryptoapp.data.source.firebase.FirebaseServicesImpl
import com.cryptoapp.project_cryptoapp.data.source.network.service.ApiService
import com.google.firebase.auth.FirebaseAuth
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

        }

    private val repositoryModule =
        module {

        }

    private val viewModelModule =
        module {
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
