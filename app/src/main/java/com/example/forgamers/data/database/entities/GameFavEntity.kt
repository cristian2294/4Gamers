package com.example.forgamers.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gameFav")
data class GameFavEntity(

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "thumbnail")
    val thumbnail: String,
    @ColumnInfo(name = "shortDescription")
    val shortDescription: String,
    @ColumnInfo(name = "genre")
    val genre: String,
    @ColumnInfo(name = "platform")
    val platform: String,
    @ColumnInfo(name = "developer")
    val developer: String,
    @ColumnInfo(name = "game_url")
    val gameUrl: String
)