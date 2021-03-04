package com.rikai.baseandroid.data.remote

import com.rikai.baseandroid.data.model.Player
import retrofit2.Response
import retrofit2.http.GET

interface Service {
    @GET("api/v1/player/")
    suspend fun getAllPlayers(): Response<List<Player>>
}