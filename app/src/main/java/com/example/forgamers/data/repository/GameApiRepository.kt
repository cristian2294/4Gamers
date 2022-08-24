package com.example.forgamers.data.repository

import com.example.forgamers.data.model.Game
import com.example.forgamers.data.network.GameService
import javax.inject.Inject

class GameApiRepository @Inject constructor(private val api: GameService) {

    suspend fun getAllLiveGames():List<Game> = api.getAllLiveGames()

    suspend fun getGameDetail(id: String): Game = api.getGameDetail(id)
}