package com.dre.android

import android.content.SharedPreferences
import com.dre.android.preferences.PreferencesDatabase
import io.mockk.*
import org.junit.Before
import org.junit.Test

internal class PreferencesDatabaseTest {

    private val mockSharedPreferences: SharedPreferences = mockk()
    private lateinit var preferencesDatabase: PreferencesDatabase

    @Before
    fun before() {
        preferencesDatabase = PreferencesDatabase(mockSharedPreferences)
    }

    @Test
    fun shouldSaveValue() {
        // Given
        val key = "some_key"
        val value = "a_value"
        val mockEditor: SharedPreferences.Editor = mockk()
        every { mockSharedPreferences.edit() } returns mockEditor
        every { mockEditor.putString(key, value) } returns mockEditor
        every { mockEditor.apply() } just runs

        // When
        preferencesDatabase.put(key, value)

        // Then
        verifyOrder {
            mockSharedPreferences.edit()
            mockEditor.putString(key, value)
            mockEditor.apply()
        }
    }

    @Test
    fun shouldGetStringFromSharedPreferences() {
        // Given
        val key = "a_key"
        val defaultValue = "a_default_value"
        every { mockSharedPreferences.getString(key, defaultValue) } returns ""

        // When
        preferencesDatabase.getString(key, defaultValue)

        // Then
        verify { mockSharedPreferences.getString(key, defaultValue) }
    }
}
