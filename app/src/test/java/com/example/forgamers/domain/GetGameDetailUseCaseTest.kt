package com.example.forgamers.domain

import com.example.forgamers.data.model.Game
import com.example.forgamers.data.repository.GameApiRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import java.util.*

class GetGameDetailUseCaseTest{

    @RelaxedMockK
    private lateinit var gameApiRepository: GameApiRepository

    private lateinit var getGameDetailUseCase: GetGameDetailUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getGameDetailUseCase  = GetGameDetailUseCase(gameApiRepository)
    }

    @Test
    fun `when exist a response then API returns a game`() = runBlocking{

        //Given
        @Suppress("DEPRECATION") val mockReleaseDate = Date(2010,1,1)
        val mockGame = Game("1","game 1","https://image.png","shortDescp",
        "https://url","genre","windows","publisher","developer",
            mockReleaseDate,"https://url", "description")
        coEvery { gameApiRepository.getGameDetail(any()) } returns mockGame

        //When
        val response = getGameDetailUseCase("1")

        //Then
        coVerify(exactly = 1) { gameApiRepository.getGameDetail(any()) }
        assert(response == mockGame)
    }
}