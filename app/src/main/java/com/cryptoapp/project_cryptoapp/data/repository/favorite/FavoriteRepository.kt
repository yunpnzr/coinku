package com.cryptoapp.project_cryptoapp.data.repository.favorite

import com.cryptoapp.project_cryptoapp.data.model.Favorite
import com.cryptoapp.project_cryptoapp.utils.ResultWrapper
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {
    fun getUserFavoriteData(): Flow<ResultWrapper<Pair<List<Favorite>, Int>>>
    fun createFavorite(
        favorite: Favorite,
    ): Flow<ResultWrapper<Boolean>>
    fun deleteFavorite(item: Favorite): Flow<ResultWrapper<Boolean>>
    suspend fun deleteAll()
}