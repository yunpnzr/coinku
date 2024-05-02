package com.cryptoapp.project_cryptoapp.data.datasource.favorite

import com.cryptoapp.project_cryptoapp.data.source.local.database.dao.FavoriteDao
import com.cryptoapp.project_cryptoapp.data.source.local.database.entity.FavoriteEntity
import kotlinx.coroutines.flow.Flow

class FavoriteDatabaseDataSource(
    private val dao: FavoriteDao
) : FavoriteDataSource {
    override fun getAllFavorites(): Flow<List<FavoriteEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertFavorite(cart: FavoriteEntity): Long {
        TODO("Not yet implemented")
    }

    override suspend fun updateFavorite(cart: FavoriteEntity): Int {
        TODO("Not yet implemented")
    }

    override suspend fun deleteFavorite(cart: FavoriteEntity): Int {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAll() = dao.deleteAll()
}