package com.cryptoapp.project_cryptoapp.data.datasource.favorite

import com.cryptoapp.project_cryptoapp.data.source.local.database.entity.FavoriteEntity
import kotlinx.coroutines.flow.Flow

interface FavoriteDataSource {
    fun getAllFavorites(): Flow<List<FavoriteEntity>>

    suspend fun insertFavorite(cart: FavoriteEntity): Long
    suspend fun updateFavorite(cart: FavoriteEntity): Int
    suspend fun deleteFavorite(cart: FavoriteEntity): Int
    suspend fun deleteAll()
}