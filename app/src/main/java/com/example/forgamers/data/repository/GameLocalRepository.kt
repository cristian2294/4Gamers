package com.example.forgamers.data.repository

import com.example.forgamers.data.model.GameCatalogProvider
import javax.inject.Inject

class GameLocalRepository @Inject constructor(private val local: GameCatalogProvider)  {

    suspend fun getAllCategories():List<String> = local.catalogList
}