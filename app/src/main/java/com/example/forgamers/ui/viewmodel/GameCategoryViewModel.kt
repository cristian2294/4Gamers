package com.example.forgamers.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.forgamers.data.model.Game
import com.example.forgamers.domain.GetAllCategoriesUseCase
import com.example.forgamers.domain.GetGamesByCategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class GameCategoryViewModel @Inject constructor(
    private val getGamesByCategoryUseCase: GetGamesByCategoryUseCase,
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase
    ): ViewModel(){

    val gameCategoryModel = MutableLiveData<List<Game>>()
    val gameCatalogModel = MutableLiveData<List<String>>()

    fun getGamesByCategory(category : String) {
        viewModelScope.launch {
            val gameResponse = withContext(Dispatchers.IO){
                getGamesByCategoryUseCase(category)
            }
            gameCategoryModel.value = gameResponse
        }
    }

    fun getAllGameCategories(){
        viewModelScope.launch {
            val gameCategoryResponse = withContext(Dispatchers.IO){
                getAllCategoriesUseCase()
            }
            gameCatalogModel.value = gameCategoryResponse
        }
    }
}


