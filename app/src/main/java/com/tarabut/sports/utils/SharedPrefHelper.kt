package com.tarabut.sports.utils

import android.content.SharedPreferences
import com.tarabut.sports.SportsApp
import com.tarabut.sports.utils.PreferenceUtil.get
import com.tarabut.core.common.SharedPrefConstants

/****
 * Keep all shared preference related methods here
 * Author: Lajesh Dineshkumar
 *****/
class SharedPrefHelper {

    private var sharedPreferences: SharedPreferences =
        PreferenceUtil.customPrefs(SportsApp.applicationContext(), SharedPrefConstants.APP_PREFS)

    fun getToken(): String? {
        return sharedPreferences[SharedPrefConstants.TOKEN]
    }

    fun getCurrentLocale(): LocaleManager.LocaleInfo? {
        return LocaleManager.getCurrentLocaleInfo(SportsApp.localeContext())
    }
}