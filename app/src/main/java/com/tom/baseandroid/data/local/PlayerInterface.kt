package com.tom.baseandroid.data.local

import com.tom.baseandroid.data.model.Player
import com.tom.baseandroid.data.model.User
import io.realm.Realm

interface PlayerInterface {

    // player
    fun addOrUpdatePlayer(player: Player) : Boolean
    fun getPlayer(playerId: String) : Player?
    fun saveAll(players: List<Player>) : Boolean

    // user account
    fun addOrUpdateUser(user: User) : Boolean
    fun getUser(email: String, password: String) : User?
}