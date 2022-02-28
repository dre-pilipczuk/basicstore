package com.dre.android.preferences

import android.content.SharedPreferences
import com.dre.domain.database.KeyValueDatabaseInterface

internal class PreferencesDatabase(
    private val preferences: SharedPreferences,
) : KeyValueDatabaseInterface {

    override fun put(key: String, value: String) {
        preferences.edit().putString(key, value).apply()
    }

    override fun getString(key: String, defValue: String): String {
        // OK to say it's non null as the default value is not null
        return preferences.getString(key, defValue)!!
    }
}
