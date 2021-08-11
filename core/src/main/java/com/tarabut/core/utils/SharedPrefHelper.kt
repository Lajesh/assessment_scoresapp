package com.tarabut.core.utils

import android.content.Context
import android.content.SharedPreferences
import com.tarabut.core.utils.PreferenceUtil.get
import com.tarabut.core.utils.PreferenceUtil.set
import com.tarabut.core.common.SharedPrefConstants

/****
 * Keep all shared preference related methods here
 * Author: Lajesh Dineshkumar
 *****/
class SharedPrefHelper constructor(context: Context) {

    private var sharedPreferences: SharedPreferences =
        PreferenceUtil.customPrefs(context, SharedPrefConstants.APP_PREFS)

    fun getToken(): String? {
        return sharedPreferences[SharedPrefConstants.TOKEN]
    }

    fun setToken(token: String?) {
        sharedPreferences[SharedPrefConstants.TOKEN] = token
    }

}