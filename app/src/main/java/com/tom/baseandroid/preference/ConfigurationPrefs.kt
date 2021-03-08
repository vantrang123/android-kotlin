package com.tom.baseandroid.preference

import android.content.Context
import com.google.gson.Gson
import com.tom.baseandroid.data.model.BaseConfig
import com.tom.baseandroid.data.model.User
import com.tom.baseandroid.utils.Utils.languageDefault
import javax.inject.Inject

/**
 * Created by vantrang on 8/16/20.
 */
class ConfigurationPrefs @Inject constructor(
        private val context: Context,
        private val baseConfig: BaseConfig
) : IConfigurationPrefs {

    private val pref by lazy {
        context.getSharedPreferences(baseConfig.applicationID, Context.MODE_PRIVATE)
    }

    override var apiToken: String?
        get() = pref.getString(KEY_API_TOKEN, null)
        set(token) = pref.edit().putString(KEY_API_TOKEN, token).apply()

    override var language: String
        get() = pref.getString(KEY_LANGUAGE_DATA, languageDefault())
                ?: languageDefault()
        set(lang) = pref.edit().putString(KEY_LANGUAGE_DATA, lang).apply()

    override var user: User?
        get() = Gson().fromJson(pref.getString(KEY_USER, null), User::class.java)
        set(value) = pref.edit().putString(KEY_USER, Gson().toJson(value)).apply()

    companion object {
        private const val KEY_API_TOKEN = "KEY_API_TOKEN"
        private const val KEY_LANGUAGE_DATA = "KEY_LANGUAGE"
        private const val KEY_USER = "KEY_USER"
    }
}