package com.cryptoapp.project_cryptoapp.data.mapper

import com.cryptoapp.project_cryptoapp.data.model.User
import com.google.firebase.auth.FirebaseUser

fun FirebaseUser?.toUser() =
    this?.let {
        User(
            id = this.uid,
            name = this.displayName.orEmpty(),
            email = this.email.orEmpty(),
            imgProfile = this.photoUrl,
        )
    }
