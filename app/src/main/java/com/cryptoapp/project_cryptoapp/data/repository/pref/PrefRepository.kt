package com.cryptoapp.project_cryptoapp.data.repository.pref

interface PrefRepository {
    fun isFirstRun(): Boolean

    fun setFirstRun(isFirstRun: Boolean)
}
