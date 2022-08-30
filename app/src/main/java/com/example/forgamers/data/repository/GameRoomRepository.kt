package com.example.forgamers.data.repository

import androidx.annotation.WorkerThread
import com.example.forgamers.data.database.dao.GameFavDAO
import com.example.forgamers.data.database.entities.GameFavEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GameRoomRepository @Inject constructor( private val gameFavDAO: GameFavDAO) {

    // Declares the DAO as a private property in the constructor. Pass in the DAO
    // instead of the whole database, because you only need access to the DAO
    val allFavoriteGames: Flow<List<GameFavEntity>> = gameFavDAO.getAllFavoriteGames()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun addFavoritePokemon(gameFavEntity: GameFavEntity) {
        gameFavDAO.addFavoriteGame(gameFavEntity)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun removeFavoriteGame(gameFavEntity: GameFavEntity) {
        gameFavDAO.removeFavoriteGame(gameFavEntity)
    }
}