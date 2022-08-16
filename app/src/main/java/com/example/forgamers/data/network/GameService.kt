package com.example.forgamers.data.network

import com.example.forgamers.data.model.GameResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GameService @Inject constructor( private val api: GameApiClient) {

    suspend fun getAllLiveGames(): GameResponse{
        return withContext(Dispatchers.IO){
            val response = api.getAllLiveGames()
            response.body()!!
        }
    }
}