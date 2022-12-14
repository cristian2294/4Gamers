package com.example.forgamers.data.network

import com.example.forgamers.data.model.Game
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GameService @Inject constructor( private val api: GameApiClient) {

      suspend fun getAllLiveGames(): List<Game>{
        return withContext(Dispatchers.IO){
            val response = api.getAllLiveGames()
            response.body()!!
        }
      }

      suspend fun  getGameDetail(id: String): Game{
        return withContext(Dispatchers.IO){
            val response = api.getGameDetail(id)
            response.body()!!
        }
      }

    suspend fun getGamesByCategory(category: String): List<Game>{
        return withContext(Dispatchers.IO){
            val response = api.getGamesByCategory(category)
            response.body()!!
        }
    }
}