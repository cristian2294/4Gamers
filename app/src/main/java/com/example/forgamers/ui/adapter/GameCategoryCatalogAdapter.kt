package com.example.forgamers.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.forgamers.R
import com.example.forgamers.data.model.GameCategory
import com.example.forgamers.data.model.GameCategoryCatalog
import com.example.forgamers.ui.viewholder.GameCategoryCatalogViewHolder

class GameCategoryCatalogAdapter(private val context: Context,
                                 private val gameCategoryCatalogList: List<GameCategoryCatalog> ): RecyclerView.Adapter<GameCategoryCatalogViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameCategoryCatalogViewHolder {
        val layoutView = LayoutInflater.from(parent.context)
            .inflate(R.layout.template_row_game_category_catalog, parent, false)
        return GameCategoryCatalogViewHolder(layoutView)
    }

    override fun onBindViewHolder(holder: GameCategoryCatalogViewHolder, position: Int) {
        val category = gameCategoryCatalogList[position]

        holder.tvCategoryCatalogGameName.text = category.catalogCategoryName

        setGameCategoryRecycler(holder.rvCategoryCatalogGame,category.categories)
    }

    override fun getItemCount(): Int  = gameCategoryCatalogList.size

    //provides setup for child Recycler "GameCategory"
    private fun setGameCategoryRecycler(recyclerView: RecyclerView, gameCategoryList: List<GameCategory>){
        val gameCategoryAdapter =  GameCategoryAdapter(context,gameCategoryList)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        recyclerView.adapter = gameCategoryAdapter
    }
}