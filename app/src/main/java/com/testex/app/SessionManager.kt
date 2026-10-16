package com.testex.app

import android.content.Context
import com.google.gson.Gson

class SessionManager(context: Context) {
    private val prefs = context.getSharedPreferences("session", Context.MODE_PRIVATE)
    private val gson = Gson()

    fun saveUser(user: UserData) {
        prefs.edit().putString("user", gson.toJson(user)).apply()
    }

    fun getUser(): UserData? {
        val json = prefs.getString("user", null) ?: return null
        return try { gson.fromJson(json, UserData::class.java) } catch (e: Exception) { null }
    }

    fun clear() { prefs.edit().clear().apply() }
}
