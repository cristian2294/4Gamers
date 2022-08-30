package com.example.forgamers.data.database.dao

import androidx.room.*
import com.example.forgamers.data.database.entities.GameFavEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GameFavDAO {

    @Query("SELECT * FROM gameFav ORDER BY id ASC")
    fun getAllFavoriteGames(): Flow<List<GameFavEntity>>

    @Query("SELECT * FROM gameFav WHERE title LIKE :title")
    suspend fun findGameFavByTitle(title: String): GameFavEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavoriteGame(game: GameFavEntity)

    @Delete
    suspend fun removeFavoriteGame(game: GameFavEntity)
}