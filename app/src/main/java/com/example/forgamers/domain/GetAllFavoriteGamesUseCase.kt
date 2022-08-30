package com.example.forgamers.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.example.forgamers.data.database.entities.GameFavEntity
import com.example.forgamers.data.repository.GameRoomRepository
import javax.inject.Inject

class GetAllFavoriteGamesUseCase @Inject constructor(private val repository: GameRoomRepository) {

    fun getFavoriteGames(): LiveData<List<GameFavEntity>> = repository.allFavoriteGames.asLiveData()
}