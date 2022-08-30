package com.example.forgamers.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.forgamers.data.database.dao.GameFavDAO
import com.example.forgamers.data.database.entities.GameFavEntity

@Database(
    entities = [GameFavEntity::class],
    version = 1,
    exportSchema = false
)
abstract class FavGamesDb: RoomDatabase() {

    abstract fun getDao(): GameFavDAO

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: FavGamesDb? = null

        fun getDatabase(context: Context): FavGamesDb {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FavGamesDb::class.java,
                    "favoriteGamesDatabase"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}