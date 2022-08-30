package com.example.forgamers.domain

import com.example.forgamers.data.database.entities.GameFavEntity
import com.example.forgamers.data.repository.GameRoomRepository
import io.mockk.MockKAnnotations
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class RemoveFavoriteGameUseCaseTest{

    @RelaxedMockK
    private lateinit var gameRoomRepository: GameRoomRepository

    private lateinit var removeFavoriteGameUseCase: RemoveFavoriteGameUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        removeFavoriteGameUseCase = RemoveFavoriteGameUseCase(gameRoomRepository)
    }

    @Test
    fun `when exist a entity then remove a favorite game`() = runBlocking{

        //Given
        val mockEntity = GameFavEntity(1,"title","thumbnail","shortDescription",
        "genre", "platform","developer")

        //When
        removeFavoriteGameUseCase(mockEntity)

        //Then
        coVerify(exactly = 1) { gameRoomRepository.removeFavoriteGame(any()) }

    }
}