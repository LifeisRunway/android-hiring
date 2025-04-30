package com.example.myapplication.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

object PrefsManager {
    private const val PREF_NAME = "app_prefs"
    private lateinit var preferences: SharedPreferences

    fun init(context: Context) {
        preferences = context.applicationContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    var isMale: Int
        get() = preferences.getInt("isMale", -1)
        set(value) = preferences.edit { putInt("isMale", value) }

    var selectedAge: Int
        get() = preferences.getInt("selectedAge", -1)
        set(value) = preferences.edit { putInt("selectedAge", value) }
}