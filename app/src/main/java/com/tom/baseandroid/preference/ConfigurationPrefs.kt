package com.tom.baseandroid.preference

import android.content.Context
import com.tom.baseandroid.data.model.BaseConfig
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

    companion object {
        private const val KEY_API_TOKEN = "KEY_API_TOKEN"
        private const val KEY_LANGUAGE_DATA = "KEY_LANGUAGE"
    }
}