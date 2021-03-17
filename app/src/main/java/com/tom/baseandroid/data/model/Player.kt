package com.tom.baseandroid.data.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class Player : RealmObject() {
    @PrimaryKey
    var id: String = UUID.randomUUID().toString()
    var firstName: String? = null
    var lastName: String? = null
    var gender: String? = null
    var rank: Int? = 0
    var country: String? = null
    var description: String? = null
    var imageUrl: String? = null
    var age: Int? = 0
    var points: Long? = 0
    var isFavorite: Boolean? = false
}