package com.example.forgamers.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.forgamers.R
import com.example.forgamers.data.model.Game
import com.example.forgamers.ui.viewholder.GameCategoryViewHolder

class GameCategoryAdapter(
    private val context: Context,
    private val gameList: List<Game>
): RecyclerView.Adapter<GameCategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameCategoryViewHolder {

        val layoutView = LayoutInflater.from(parent.context)
            .inflate(R.layout.template_game_category, parent, false)
        return GameCategoryViewHolder(layoutView)

    }

    override fun onBindViewHolder(holder: GameCategoryViewHolder, position: Int) {

        val category = gameList[position]
        val urlGameImage = category.thumbnail

        Glide.with(context)
            .load(urlGameImage)
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(holder.ivGameCategory)
    }

    override fun getItemCount(): Int = gameList.size
}