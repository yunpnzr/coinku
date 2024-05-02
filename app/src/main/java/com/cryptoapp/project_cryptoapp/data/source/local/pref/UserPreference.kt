package com.cryptoapp.project_cryptoapp.data.source.local.pref

import android.content.SharedPreferences
import android.util.Log
import com.cryptoapp.project_cryptoapp.utils.SharedPreferenceUtils.set

interface UserPreference {
    fun isFirstRun(): Boolean
    fun setFirstRun(isFirstRun: Boolean)
}

class UserPreferenceImpl(private val pref: SharedPreferences) : UserPreference {
    override fun isFirstRun(): Boolean {
        return pref.getBoolean(KEY_IS_FIRST_RUN, false)
    }

    override fun setFirstRun(isFirstRun: Boolean) {
        pref[KEY_IS_FIRST_RUN] = isFirstRun
        Log.e(TAG, "Saving value user pref $isFirstRun")
    }

    companion object {
        const val TAG = "User Preferences"
        const val PREF_NANE = "cryptoapp-pref"
        const val KEY_IS_FIRST_RUN = "KEY_IS_FIRST_RUN"
    }
}
