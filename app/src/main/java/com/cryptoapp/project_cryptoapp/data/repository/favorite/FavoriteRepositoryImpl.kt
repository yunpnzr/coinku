package com.cryptoapp.project_cryptoapp.data.repository.favorite

import com.cryptoapp.project_cryptoapp.data.datasource.favorite.FavoriteDataSource
import com.cryptoapp.project_cryptoapp.data.model.Favorite
import com.cryptoapp.project_cryptoapp.utils.ResultWrapper
import kotlinx.coroutines.flow.Flow

class FavoriteRepositoryImpl(private val favoriteDataSource: FavoriteDataSource) : FavoriteRepository {
    override fun getUserFavoriteData(): Flow<ResultWrapper<Pair<List<Favorite>, Int>>> {
        // TODO
    }

    override fun createFavorite(
        favorite: Favorite
    ): Flow<ResultWrapper<Boolean>> {
        // TODO
    }

    override fun deleteFavorite(item: Favorite): Flow<ResultWrapper<Boolean>> {
//        return proceedFlow { favoriteDataSource.deleteCart(item.toCartEntity()) > 0 }
    }

    override suspend fun deleteAll() {
        favoriteDataSource.deleteAll()
    }
}