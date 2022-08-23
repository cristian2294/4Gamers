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
import java.time.LocalDate

class GetAllLiveGamesUseCaseTest{

    @RelaxedMockK
    private lateinit var gameApiRepository: GameApiRepository

    private lateinit var getAllLiveGamesUseCase: GetAllLiveGamesUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getAllLiveGamesUseCase = GetAllLiveGamesUseCase(gameApiRepository)
    }

    @Test
    fun `when the API return something then get values from the API `() = runBlocking{

        //Given
        val releaseDate =  LocalDate.of(2010, 1, 1)
        val mockResult = Game("1","league of legendes","https//:img1.jpg",
        "short Description","https//url","genre","Pc",
            "Riot Games","Riot Games",releaseDate,"https://url2")
        val mockListGames = listOf(mockResult)
        coEvery { gameApiRepository.getAllLiveGames() } returns mockListGames

        //When
        val response = getAllLiveGamesUseCase()

        //Then
        coVerify(exactly = 1) { gameApiRepository.getAllLiveGames() }
        assert(mockListGames == response)

    }

}