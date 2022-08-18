package com.example.forgamers.domain

import com.example.forgamers.data.model.Game
import com.example.forgamers.data.repository.GameApiRepository
import javax.inject.Inject

class GetAllLiveGamesUseCase @Inject constructor( private val gameApiRepository: GameApiRepository) {

    suspend operator fun invoke(): List<Game> = gameApiRepository.getAllLiveGames()

}