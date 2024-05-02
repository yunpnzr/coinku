package com.cryptoapp.project_cryptoapp.data.mapper

import com.cryptoapp.project_cryptoapp.data.model.Favorite
import com.cryptoapp.project_cryptoapp.data.source.local.database.entity.FavoriteEntity

fun Favorite?.toFavoriteEntity() =
    FavoriteEntity(
        cryptoId = this?.cryptoId.orEmpty(),
        name = this?.name.orEmpty(),
        currentPrice = this?.currentPrice ?: 0.0,
        image = this?.image.orEmpty(),
        symbol = this?.symbol.orEmpty()
    )

fun FavoriteEntity?.toFavorite() =
    Favorite(
        id = this?.id,
        cryptoId = this?.cryptoId.orEmpty(),
        currentPrice = this?.currentPrice ?: 0.0,
        image = this?.image.orEmpty(),
        name = this?.name.orEmpty(),
        symbol = this?.symbol.orEmpty()
    )

fun List<FavoriteEntity?>.toFavoriteList() =
    this.map {
        it.toFavorite()
    }