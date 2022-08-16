package com.example.forgamers.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.forgamers.data.model.GameResponse
import com.example.forgamers.domain.GetAllLiveGamesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val getAllLiveGamesUseCase: GetAllLiveGamesUseCase
) : ViewModel() {

    val gameModel = MutableLiveData<GameResponse>()

    fun getLiveGames(){
        viewModelScope.launch {
            val gameResponse = withContext(Dispatchers.IO){
                getAllLiveGamesUseCase()
            }
            gameModel.value = gameResponse
        }
    }
}