package com.example.forgamers.data.network

import com.example.forgamers.data.model.Game
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GameApiClient {

    @GET("games")
    suspend fun getAllLiveGames(): Response<List<Game>>

    @GET("game?")
    suspend fun getGameDetail(@Query("id") id: String): Response<Game>
}