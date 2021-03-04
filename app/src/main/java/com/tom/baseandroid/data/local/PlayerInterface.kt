package com.tom.baseandroid.data.local

import com.tom.baseandroid.data.model.Player
import io.realm.Realm

interface PlayerInterface {
    fun addOrUpdatePlayer(realm: Realm, player: Player) : Boolean
    fun getPlayer(playerId: String) : Player?
    fun saveAll(players: List<Player>) : Boolean
}