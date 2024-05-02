package com.cryptoapp.project_cryptoapp.data.source.local.database.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.cryptoapp.project_cryptoapp.data.source.local.database.entity.FavoriteEntity
import kotlinx.coroutines.flow.Flow

interface FavoriteDao {
    @Query("SELECT * FROM favorite")
    fun getAllFavorite(): Flow<List<FavoriteEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(favorite: FavoriteEntity): Long

    @Update
    suspend fun updateFavorite(favorite: FavoriteEntity): Int

    @Delete
    suspend fun deleteFavorite(favorite: FavoriteEntity): Int

    @Query("DELETE FROM favorite")
    fun deleteAll()
}