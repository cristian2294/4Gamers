package com.example.forgamers.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.forgamers.R
import com.example.forgamers.data.model.Game
import com.example.forgamers.ui.viewholder.GameViewHolder

class GameAdapter(private val context: Context,
    private val gameList: List<Game>) : RecyclerView.Adapter<GameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val layoutView = LayoutInflater.from(parent.context)
            .inflate(R.layout.template_game_list, parent, false)
        return GameViewHolder(layoutView)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {

        val game = gameList[position]
        val urlGameImage = game.thumbnail

        // implements method when the user click an item
        holder.render(game.id)

        holder.gameName.text = game.title
        holder.gameGenre.text = game.genre
        holder.gameDescription.text = game.shortDescription
        holder.gamePlatform.text = game.platform
        Glide.with(context)
            .load(urlGameImage)
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(holder.gameImage)
    }

    // return list size
    override fun getItemCount(): Int = gameList.size
}