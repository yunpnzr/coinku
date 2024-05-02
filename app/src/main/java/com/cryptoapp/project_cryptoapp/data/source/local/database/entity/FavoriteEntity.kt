package com.cryptoapp.project_cryptoapp.data.source.local.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite")
data class FavoriteEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo("crypto_id")
    var cryptoId: String? = null,
    @ColumnInfo("crypto_name")
    var name: String,
    @ColumnInfo("current_price")
    var currentPrice: Double,
    @ColumnInfo("image")
    var image: String,
    @ColumnInfo("symbol")
    var symbol: String,
)