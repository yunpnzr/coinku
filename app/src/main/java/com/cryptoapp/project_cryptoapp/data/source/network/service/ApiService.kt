package com.cryptoapp.project_cryptoapp.data.source.network.service

import com.cryptoapp.project_cryptoapp.BuildConfig
import com.cryptoapp.project_cryptoapp.data.source.network.model.detailcrypto.DetailCryptoResponse
import com.cryptoapp.project_cryptoapp.data.source.network.model.listcrypto.ListCryptoResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface ApiService {
    @Headers("Authorization: token ${BuildConfig.KEY}")
    @GET("markets")
    suspend fun getCrypto(
        @Query("vs_currency") vsCurrency: String,
    ): ListCryptoResponse

    @GET("{id}")
    suspend fun getDetail(
        @Path("username") username: String,
    ): DetailCryptoResponse

    companion object {
        @JvmStatic
        operator fun invoke(): ApiService {
            val levelInterceptor = HttpLoggingInterceptor.Level.BODY
            val loggingInterceptor = HttpLoggingInterceptor().setLevel(levelInterceptor)
            val okHttpClient =
                OkHttpClient.Builder()
                    .connectTimeout(100, TimeUnit.SECONDS)
                    .readTimeout(100, TimeUnit.SECONDS)
                    .addInterceptor(loggingInterceptor)
                    .build()
            val retrofit =
                Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}
