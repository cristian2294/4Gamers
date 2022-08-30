package com.example.forgamers.di

import android.content.Context
import androidx.room.Room
import com.example.forgamers.data.database.FavGamesDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val FAV_GAME_DATABASE_NAME = "favoriteGamesDatabase"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) = Room.databaseBuilder(context,
        FavGamesDb::class.java,
        FAV_GAME_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideGameFavDAO(db:FavGamesDb) = db.getDao()
}