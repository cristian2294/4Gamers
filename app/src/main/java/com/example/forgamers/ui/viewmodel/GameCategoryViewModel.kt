package com.example.forgamers.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.forgamers.data.model.Game
import com.example.forgamers.domain.GetGamesByCategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class GameCategoryViewModel @Inject constructor(
    private val getGamesByCategoryUseCase: GetGamesByCategoryUseCase
    ): ViewModel(){

    val gameCategoryModel = MutableLiveData<List<Game>>()

    fun getGamesByCategory(category : String){
        viewModelScope.launch {
            val gameResponse = withContext(Dispatchers.IO){
                getGamesByCategoryUseCase(category)
            }
            gameCategoryModel.value = gameResponse
        }
    }
}


