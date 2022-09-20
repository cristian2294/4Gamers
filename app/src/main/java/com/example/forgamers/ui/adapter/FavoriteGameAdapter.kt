package com.example.forgamers.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.forgamers.R
import com.example.forgamers.data.database.entities.GameFavEntity
import com.example.forgamers.ui.viewholder.FavoriteGameViewHolder
import com.example.forgamers.ui.viewmodel.GameDetailViewModel

class FavoriteGameAdapter(private val gameDetailViewModel: GameDetailViewModel
    ): RecyclerView.Adapter<FavoriteGameViewHolder>() {

    private var favoriteGameList = emptyList<GameFavEntity>()
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteGameViewHolder {

        val layoutView = LayoutInflater.from(parent.context)
            .inflate(R.layout.template_favorite_game_list, parent, false)

        context = parent.context
        return FavoriteGameViewHolder(layoutView)
    }

    override fun onBindViewHolder(holder: FavoriteGameViewHolder, position: Int) {

        val favoriteGame = favoriteGameList[position]
        val urlGameImage = favoriteGame.thumbnail

        holder.tvFavGameName.text = favoriteGame.title
        holder.tvFavGameDeveloper.text = favoriteGame.developer

        Glide.with(context)
            .load(urlGameImage)
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(holder.ivFavGame)

        holder.btnFavGame.setOnClickListener {
            if (holder.btnFavGame.isChecked == false){
                removeFavoriteGame(favoriteGame)
            }
        }
    }

    private fun removeFavoriteGame(favoriteGame: GameFavEntity) {
        gameDetailViewModel.removeFavoriteGame(favoriteGame)

        val messageSuccess = "Game has been successfully removed from your favorites!"
        Toast.makeText(context, messageSuccess, Toast.LENGTH_SHORT).show()
    }

    override fun getItemCount(): Int = favoriteGameList.size

    fun setData(favoriteGameList: List<GameFavEntity>){
        this.favoriteGameList = favoriteGameList
        notifyDataSetChanged()
    }
}