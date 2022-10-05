package com.example.forgamers.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.forgamers.R
import com.example.forgamers.data.model.GameCategory
import com.example.forgamers.ui.viewholder.GameCategoryViewHolder

class GameCategoryAdapter(
    private val context: Context,
    private val gameCategoryList: List<GameCategory>
): RecyclerView.Adapter<GameCategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameCategoryViewHolder {

        val layoutView = LayoutInflater.from(parent.context)
            .inflate(R.layout.template_game_category, parent, false)
        return GameCategoryViewHolder(layoutView)

    }

    override fun onBindViewHolder(holder: GameCategoryViewHolder, position: Int) {

        val category = gameCategoryList[position]

        holder.nameCat.text = category.categoryName
    }

    override fun getItemCount(): Int = gameCategoryList.size
}