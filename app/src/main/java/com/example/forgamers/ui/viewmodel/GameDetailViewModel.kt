package com.example.forgamers.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.forgamers.data.model.Game
import com.example.forgamers.domain.GetGameDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class GameDetailViewModel @Inject constructor(
    private val getGameDetailUseCase: GetGameDetailUseCase
): ViewModel() {

    val gameModel = MutableLiveData<Game>()

    fun getGameDetail(id: String){
        viewModelScope.launch {
            val game = withContext(Dispatchers.IO){
                getGameDetailUseCase(id)
            }
            gameModel.value = game
        }
    }
}