package com.example.forgamers.domain

import androidx.lifecycle.asLiveData
import com.example.forgamers.data.database.entities.GameFavEntity
import com.example.forgamers.data.repository.GameRoomRepository
import io.mockk.MockKAnnotations
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.flow.asFlow
import org.junit.Before
import org.junit.Test

class GetAllFavoriteGamesUseCaseTest{

    @RelaxedMockK
    private lateinit var gameRoomRepository: GameRoomRepository

    private lateinit var getAllFavoriteGamesUseCase: GetAllFavoriteGamesUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getAllFavoriteGamesUseCase = GetAllFavoriteGamesUseCase(gameRoomRepository)
    }

    @Test
    fun `when database is not empty then returns a game entity list`(){

        //Given
        val mockGameEntity1 = GameFavEntity(1,"title","thumbnail","description",
            "genre","platform","developer")

        val mockGameEntity2 = GameFavEntity(2,"title2","thumbnail2","description2",
            "genre2","platform2","developer2")
        
        val mockGameList = listOf(mockGameEntity1,mockGameEntity2).asFlow().asLiveData()

        //When
        getAllFavoriteGamesUseCase.getFavoriteGames()

        //Then
        coVerify(exactly =  1) { gameRoomRepository.allFavoriteGames }
    }
}