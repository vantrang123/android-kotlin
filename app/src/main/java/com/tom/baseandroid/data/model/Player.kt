package com.tom.baseandroid.data.model

import io.realm.RealmObject

open class Player : RealmObject() {
    var id: String? = null
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