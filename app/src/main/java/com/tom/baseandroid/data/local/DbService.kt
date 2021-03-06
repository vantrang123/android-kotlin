package com.tom.baseandroid.data.local

import com.tom.baseandroid.data.model.Player
import com.tom.baseandroid.data.model.User
import io.realm.Realm

class DbService : PlayerInterface {
    override fun addOrUpdatePlayer(player: Player): Boolean {
        val realm = Realm.getDefaultInstance()
        return try {
            realm.use {
                it.beginTransaction()
                it.copyToRealmOrUpdate(player)
                it.commitTransaction()
                it.close()
            }
            true
        } catch (e: Exception) {
            false
        }
    }

    override fun getPlayer(playerId: String): Player? {
        val realm = Realm.getDefaultInstance()
        return try {
            realm.use {
                it.copyFromRealm(it.where(Player::class.java).equalTo("id", playerId).findFirst())
            }
        } catch (e: Exception) {
            null
        }
    }

    override fun saveAll(players: List<Player>): Boolean {
        val r = Realm.getDefaultInstance()
        return try {
            r.use {
                it.beginTransaction()
                it.delete(Player::class.java)
                it.copyToRealmOrUpdate(players)
                it.commitTransaction()
                it.close()
            }
            true
        } catch (e: Exception) {
            false
        }
    }

    override fun addOrUpdateUser(user: User): Boolean {
        val realm = Realm.getDefaultInstance()
        return try {
            realm.use {
                it.beginTransaction()
                it.copyToRealmOrUpdate(user)
                it.commitTransaction()
                it.close()
            }
            true
        } catch (e: Exception) {
            false
        }
    }

    override fun getUser(email: String, password: String): User? {
        val realm = Realm.getDefaultInstance()
        return try {
            realm.use {
                it.copyFromRealm(it.where(User::class.java)
                        .equalTo("email", email)
                        .equalTo("password", password)
                        .findFirst())
            }
        } catch (e: Exception) {
            null
        }
    }
}