package com.example.forgamers.ui.viewmodel

import androidx.lifecycle.*
import com.example.forgamers.data.database.entities.GameFavEntity
import com.example.forgamers.data.model.Game
import com.example.forgamers.data.repository.GameRoomRepository
import com.example.forgamers.domain.AddFavoriteGameUseCase
import com.example.forgamers.domain.GetAllFavoriteGamesUseCase
import com.example.forgamers.domain.GetGameDetailUseCase
import com.example.forgamers.domain.RemoveFavoriteGameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class GameDetailViewModel @Inject constructor(
    private val repository: GameRoomRepository,
    private val getGameDetailUseCase: GetGameDetailUseCase,
    private val addFavoriteGameUseCase: AddFavoriteGameUseCase,
    private val removeFavoriteGameUseCase: RemoveFavoriteGameUseCase,
    private val getAllFavoriteGamesUseCase: GetAllFavoriteGamesUseCase
): ViewModel() {

    val gameModel = MutableLiveData<Game>()

    private lateinit var allFavoriteGame : LiveData<List<GameFavEntity>>

    fun getGameDetail(id: String){
        viewModelScope.launch {
            val game = withContext(Dispatchers.IO){
                getGameDetailUseCase(id)
            }
            gameModel.value = game
        }
    }

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun addFavoriteGame(gameFavEntity: GameFavEntity) = viewModelScope.launch{
        withContext(Dispatchers.IO){
            addFavoriteGameUseCase(gameFavEntity)
        }
    }

    /**
     * Launching a new coroutine to remove the data in a non-blocking way
     */
    fun removeFavoriteGame(gameFavEntity: GameFavEntity) = viewModelScope.launch {
        withContext(Dispatchers.IO){
            removeFavoriteGameUseCase(gameFavEntity)
        }
    }

    fun getAllFavoriteGames(): LiveData<List<GameFavEntity>> {
        allFavoriteGame =  getAllFavoriteGamesUseCase.getFavoriteGames()
        return allFavoriteGame
    }
}

class GameDetailViewModelFactory @Inject constructor(
    private val repository: GameRoomRepository,
    private val getGameDetailUseCase: GetGameDetailUseCase,
    private val addFavoriteGameUseCase: AddFavoriteGameUseCase,
    private val removeFavoriteGameUseCase: RemoveFavoriteGameUseCase,
    private val getAllFavoriteGamesUseCase: GetAllFavoriteGamesUseCase
): ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GameDetailViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return GameDetailViewModel(
                repository,
                getGameDetailUseCase,
                addFavoriteGameUseCase,
                removeFavoriteGameUseCase,
                getAllFavoriteGamesUseCase
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}