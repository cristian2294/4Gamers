package com.example.forgamers.domain

import com.example.forgamers.data.model.Game
import com.example.forgamers.data.repository.GameApiRepository
import javax.inject.Inject

class GetGamesByCategoryUseCase @Inject constructor( private val gameApiRepository: GameApiRepository ) {

    suspend operator fun invoke(category: String): List<Game> = gameApiRepository.getGamesByCategory(category)

}