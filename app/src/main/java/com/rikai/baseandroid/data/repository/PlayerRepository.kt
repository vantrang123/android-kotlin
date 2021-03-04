package com.rikai.baseandroid.data.repository

import com.rikai.baseandroid.data.local.DbService
import com.rikai.baseandroid.data.remote.PlayerRemote
import io.realm.Realm
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers.IO
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class PlayerRepository @Inject constructor(
    private val remote: PlayerRemote,
    private val dbService: DbService
) {

    suspend fun observerPlayers() = remote.getAllPlayers()

    suspend fun observePlayerByUUID(id: String) = dbService.getPlayer(playerId = id)
}