package com.tom.baseandroid.preference

import com.tom.baseandroid.data.model.User

interface IConfigurationPrefs {
    var apiToken: String?
    var language: String
    var user: User?
}