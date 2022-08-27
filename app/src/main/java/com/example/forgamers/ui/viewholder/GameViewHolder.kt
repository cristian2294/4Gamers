package com.example.forgamers.ui.viewholder

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.forgamers.databinding.TemplateGameListBinding
import com.example.forgamers.ui.view.GameDetailActivity

class GameViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = TemplateGameListBinding.bind(view)

    var gameImage = binding.ivGame
    var gameName = binding.tvGameName
    var gameGenre = binding.tvGameGenre
    var gameDescription = binding.tvGameDescription

    fun render(id: String){
        itemView.setOnClickListener{
            val intent = Intent(it.context, GameDetailActivity::class.java)
            intent.putExtra("gameId", id)
            it.context.startActivity(intent)
        }
    }
}