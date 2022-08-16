package com.example.forgamers.data.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class GameResponse (
    @SerializedName("games")
    var games: List<Game>
)

data class Game(
    @SerializedName("id")
    var id: String,
    @SerializedName("title")
    var title: String,
    @SerializedName("thumbnail")
    var thumbnail: String,
    @SerializedName("short_description")
    var shortDescription: String,
    @SerializedName("game_url")
    var gameUrl: String,
    @SerializedName("genre")
    var genre: String,
    @SerializedName("platform")
    var platform: String,
    @SerializedName("publisher")
    var publisher: String,
    @SerializedName("developer")
    var developer: String,
    @SerializedName("release_date")
    var releaseDate: Date,
    @SerializedName("freetogame_profile_url")
    var freeToGameProfileUrl: String,


)

