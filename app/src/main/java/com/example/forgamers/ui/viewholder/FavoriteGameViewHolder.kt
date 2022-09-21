package com.example.forgamers.ui.viewholder

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.forgamers.databinding.TemplateFavoriteGameListBinding
import com.example.forgamers.ui.view.GameDetailActivity

class FavoriteGameViewHolder(view: View, private val context: Context): RecyclerView.ViewHolder(view)  {

    private val binding = TemplateFavoriteGameListBinding.bind(view)

    var ivFavGame = binding.ivFavGame
    var tvFavGameName = binding.tvFavGameName
    var tvFavGameDeveloper = binding.tvFavGameDeveloper
    var btnFavGame = binding.tbtnFavoriteGame
    var btnGoWebsite = binding.btnFavoriteGameGoWebsite

    fun render(url: String){

        // for go to website with the game url
        btnGoWebsite.setOnClickListener {
            goToWebsite(url)
        }

    }

    private fun goToWebsite(url: String) {
        val uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        context.startActivity(intent)

    }
}