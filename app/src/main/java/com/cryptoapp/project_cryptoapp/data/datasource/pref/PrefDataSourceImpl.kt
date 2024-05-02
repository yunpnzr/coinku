package com.cryptoapp.project_cryptoapp.data.datasource.pref

import com.cryptoapp.project_cryptoapp.data.source.local.pref.UserPreference

class PrefDataSourceImpl(private val userPreference: UserPreference): PrefDataSource {
    override fun isFirstRun(): Boolean {
        return userPreference.isFirstRun()
    }

    override fun setFirstRun(isFirstRun: Boolean) {
        return userPreference.setFirstRun(isFirstRun)
    }
}