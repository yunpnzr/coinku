package com.cryptoapp.project_cryptoapp.data.model

import android.net.Uri

data class User(
    val id: String,
    val name: String,
    val email: String,
    val imgProfile: Uri?,
)

    /*{
    return this.let {
        User(
            id = it.uid,
            name = it.displayName.orEmpty(),
            email = it.email.orEmpty(),
            imgProfile = it.photoUrl
        )
    }
}*/
