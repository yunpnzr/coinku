package com.cryptoapp.project_cryptoapp.data.model

import java.util.UUID

data class CryptoDetail(
    var id: String? = UUID.randomUUID().toString(),
    var name: String?,
    var price: Double?,
    var image: String?,
    var description: String?,
)
