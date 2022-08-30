package com.example.forgamers.domain

import com.example.forgamers.data.database.entities.GameFavEntity
import com.example.forgamers.data.repository.GameRoomRepository
import io.mockk.MockKAnnotations
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


class AddFavoriteGameUseCaseTest{

    @RelaxedMockK
    private lateinit var gameRoomRepository: GameRoomRepository

    private lateinit var addFavoriteGameUseCase: AddFavoriteGameUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        addFavoriteGameUseCase = AddFavoriteGameUseCase(gameRoomRepository)
    }

    @Test
    fun `when exist a entity then add a favorite game`() = runBlocking{

        //Given
        val mockEntity = GameFavEntity(1,"title","thumbnail","description",
        "genre","platform","developer")

        //When
        addFavoriteGameUseCase(mockEntity)

        //Then
        coVerify(exactly = 1) { gameRoomRepository.addFavoritePokemon(any()) }
    }
}