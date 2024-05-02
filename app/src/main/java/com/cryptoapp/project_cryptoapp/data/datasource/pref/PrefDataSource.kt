package com.cryptoapp.project_cryptoapp.data.datasource.pref

interface PrefDataSource {
    fun isFirstRun(): Boolean

    fun setFirstRun(isFirstRun: Boolean)
}
