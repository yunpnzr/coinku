package com.cryptoapp.project_cryptoapp.data.model

import java.util.UUID

data class Favorite(
    var id: String? = UUID.randomUUID().toString(),
    var currentPrice: Double,
    var image: String,
    var name: String,
    var symbol: String,
)
