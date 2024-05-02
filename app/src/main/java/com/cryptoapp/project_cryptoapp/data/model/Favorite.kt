package com.cryptoapp.project_cryptoapp.data.model

data class Favorite(
    var id: Int? = null,
    var cryptoId: String? = null,
    var currentPrice: Double,
    var image: String,
    var name: String,
    var symbol: String,
)
