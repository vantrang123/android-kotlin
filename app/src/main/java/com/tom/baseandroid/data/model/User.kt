package com.tom.baseandroid.data.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

/**
 *Created by VanTrang on 8/22/2019.
 */
open class User : RealmObject() {
    @PrimaryKey
    var id: String = UUID.randomUUID().toString()
    var email: String? = null
    var password: String? = null
}