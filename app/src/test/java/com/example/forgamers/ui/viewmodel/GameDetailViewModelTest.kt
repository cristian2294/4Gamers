package com.example.forgamers.ui.viewmodel

import com.example.forgamers.data.model.Game
import com.example.forgamers.domain.GetGameDetailUseCase
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
import org.junit.Test
import java.util.*

@ExperimentalCoroutinesApi
class GameDetailViewModelTest{

    @RelaxedMockK
    private lateinit var getGameDetailUseCase: GetGameDetailUseCase

    private lateinit var gameDetailViewModel: GameDetailViewModel

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        gameDetailViewModel = GameDetailViewModel(getGameDetailUseCase)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter(){
        Dispatchers.resetMain()
    }

    @Test
    fun `when exist a GameId then Return a GameDetail`() = runTest {

        //Given
        @Suppress("DEPRECATION") val mockReleaseDate = Date(2010,1,1)
        val mockResponse = Game("1","game 1","https://image.png","shortDescp",
            "https://url","genre","windows","publisher","developer",
            mockReleaseDate,"https://url")
        coEvery { getGameDetailUseCase(any()) } returns mockResponse

        //When
        gameDetailViewModel.getGameDetail("1")

        //Then
        coVerify(exactly = 1) { getGameDetailUseCase(any()) }
    }
}