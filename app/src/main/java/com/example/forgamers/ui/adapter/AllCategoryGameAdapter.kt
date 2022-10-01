package com.example.forgamers.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.forgamers.R
import com.example.forgamers.data.model.AllCategoryGame
import com.example.forgamers.data.model.CategoryGame
import com.example.forgamers.ui.viewholder.AllCategoryGameViewHolder


class AllCategoryGameAdapter(private val context: Context,
                             private val allCategoryGameList: List<AllCategoryGame> ): RecyclerView.Adapter<AllCategoryGameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllCategoryGameViewHolder {
        val layoutView = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_game_category, parent, false)
        return AllCategoryGameViewHolder(layoutView)
    }

    override fun onBindViewHolder(holder: AllCategoryGameViewHolder, position: Int) {
        val category = allCategoryGameList[position]

        holder.tvCategoryGameName.text = category.categoryName
    }

    override fun getItemCount(): Int  = allCategoryGameList.size
}