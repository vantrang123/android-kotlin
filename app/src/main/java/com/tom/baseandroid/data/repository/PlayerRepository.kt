package com.tom.baseandroid.data.repository

import com.tom.baseandroid.data.local.DbService
import com.tom.baseandroid.data.remote.PlayerRemote
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlayerRepository @Inject constructor(
    private val remote: PlayerRemote,
    private val dbService: DbService
) {

    suspend fun observerPlayers() = remote.getAllPlayers()

    suspend fun observePlayerByUUID(id: String) = dbService.getPlayer(playerId = id)
}