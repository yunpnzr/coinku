package com.cryptoapp.project_cryptoapp.data.repository.pref

import com.cryptoapp.project_cryptoapp.data.datasource.pref.PrefDataSource

class PrefRepositoryImpl(private val dataSource: PrefDataSource) : PrefRepository {
    override fun isFirstRun(): Boolean {
        return dataSource.isFirstRun()
    }

    override fun setFirstRun(isFirstRun: Boolean) {
        return dataSource.setFirstRun(isFirstRun)
    }
}
