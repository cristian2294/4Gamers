package com.example.forgamers.data.network

import com.example.forgamers.data.model.GameResponse
import retrofit2.Response
import retrofit2.http.GET

interface GameApiClient {

    @GET("games")
    suspend fun getAllLiveGames(): Response<GameResponse>
}