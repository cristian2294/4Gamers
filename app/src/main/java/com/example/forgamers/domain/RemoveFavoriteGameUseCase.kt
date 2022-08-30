package com.example.forgamers.domain

import com.example.forgamers.data.database.entities.GameFavEntity
import com.example.forgamers.data.repository.GameRoomRepository
import javax.inject.Inject

class RemoveFavoriteGameUseCase @Inject constructor(private val repository: GameRoomRepository) {

    suspend operator fun invoke(gameFavEntity: GameFavEntity) = repository.removeFavoriteGame(gameFavEntity)
}