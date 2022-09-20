package com.example.forgamers.ui.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.forgamers.databinding.TemplateFavoriteGameListBinding

class FavoriteGameViewHolder(view: View): RecyclerView.ViewHolder(view)  {

    private val binding = TemplateFavoriteGameListBinding.bind(view)

    var ivFavGame = binding.ivFavGame
    var tvFavGameName = binding.tvFavGameName
    var tvFavGameDeveloper = binding.tvFavGameDeveloper
    var btnFavGame = binding.tbtnFavoriteGame
}