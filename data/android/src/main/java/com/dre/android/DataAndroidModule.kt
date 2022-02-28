package com.dre.android

import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.dre.android.preferences.PreferencesDatabase
import com.dre.domain.database.KeyValueDatabaseInterface
import org.koin.dsl.module

val dataAndroidModule = module {
    single<SharedPreferences> { PreferenceManager.getDefaultSharedPreferences(get()) }
    single<KeyValueDatabaseInterface> { PreferencesDatabase(get()) }
}
