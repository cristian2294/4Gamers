package com.example.forgamers.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.forgamers.data.model.Game
import com.example.forgamers.domain.GetAllLiveGamesUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.*

@ExperimentalCoroutinesApi
class GameViewModelTest(){

    @RelaxedMockK
    private lateinit var getAllLiveGamesUseCase: GetAllLiveGamesUseCase

    private lateinit var gameViewModel: GameViewModel

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        gameViewModel = GameViewModel(getAllLiveGamesUseCase)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter(){
        Dispatchers.resetMain()
    }

    @Test
    fun `API returns a GameList`() = runTest {

        //Given
        @Suppress("DEPRECATION") val mockReleaseDate = Date(2010,1,1)
        val mockGame = Game("1","game 1","https://image.png","shortDescp",
            "https://url","genre","windows","publisher","developer",
            mockReleaseDate,"https://url")
        val mockResponse = listOf(mockGame)
        coEvery { getAllLiveGamesUseCase() } returns mockResponse

        //When
        gameViewModel.getLiveGames()

        //Then
        coVerify(exactly = 1) { getAllLiveGamesUseCase() }
    }

}