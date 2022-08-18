package com.example.forgamers.ui.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.forgamers.databinding.TemplateGameListBinding

class GameViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = TemplateGameListBinding.bind(view)

    var gameImage = binding.ivGame
    var gameName = binding.tvGameName
    var gameGenre = binding.tvGameGenre
    var gameDescription = binding.tvGameDescription
    var gamePlatform = binding.tvGamePlatform
}