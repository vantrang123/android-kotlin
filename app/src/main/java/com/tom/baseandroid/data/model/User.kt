package com.tom.baseandroid.data.model

import io.realm.RealmObject

/**
 *Created by VanTrang on 8/22/2019.
 */
open class User : RealmObject() {
    var email: String? = null
    var password: String? = null
}