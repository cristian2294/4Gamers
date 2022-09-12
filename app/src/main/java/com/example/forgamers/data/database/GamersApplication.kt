package com.example.forgamers.data.database

import android.app.Application
import com.example.forgamers.data.repository.GameRoomRepository
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

@HiltAndroidApp
class GamersApplication: Application(){

    // No need to cancel this scope as it'll be torn down with the process
    val applicationScope = CoroutineScope(SupervisorJob())

    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { FavGamesDb.getDatabase(this) }
    val repository by lazy { GameRoomRepository(database.getDao()) }
}