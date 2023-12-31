package com.budge.hotdeal_go.core.util

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.budge.hotdeal_go.core.error.UserNotFoundException
import com.budge.hotdeal_go.data.model.Member
import com.google.gson.GsonBuilder

object EncryptedPrefs {
    private var prefs: SharedPreferences? = null
    private val gson = GsonBuilder().create()

    fun initSharedPreferences(context: Context) {
        synchronized(this) {
            val sharedPrefsFile = "HotDealPrefs"
            val masterKey = MasterKey.Builder(context)
                .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
                .build()
            prefs = EncryptedSharedPreferences.create(
                context,
                sharedPrefsFile,
                masterKey,
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            )
        }
    }

    fun putString(key: String, value: String) {
        with(prefs?.edit()) {
            this?.putString(key, value)
            this?.apply()
        }
    }

    fun getString(key: String): String {
        return prefs?.getString(key, "") ?: ""
    }

    fun putMember(key: String, value: Member) {
        val json = gson.toJson(value, Member::class.java)
        putString(key, json)
    }

    fun getMember(key: String): Member {
        val value = prefs?.getString(key, null) ?: throw UserNotFoundException()
        return gson.fromJson(value, Member::class.java)
    }

    fun clearPrefs() {
        prefs?.edit()?.clear()?.apply()
    }
}