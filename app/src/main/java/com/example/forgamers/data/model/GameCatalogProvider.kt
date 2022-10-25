package com.example.forgamers.data.model

import javax.inject.Inject

class GameCatalogProvider @Inject constructor() {

        val catalogList = listOf(
            "MMORPG",
            "shooter",
            "MOBA",
            "Anime",
            "Strategy",
            "Fantasy",
            "Sci-Fi",
            "Racing",
            "Fighting",
            "Social",
            "Sports"
        )
}