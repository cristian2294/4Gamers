package com.example.forgamers.data.repository

import com.example.forgamers.data.model.GameResponse
import com.example.forgamers.data.network.GameService
import javax.inject.Inject

class GameApiRepository @Inject constructor(private val api: GameService) {

    suspend fun getAllLiveGames():GameResponse = api.getAllLiveGames()
}