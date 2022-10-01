package com.example.forgamers.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.forgamers.R
import com.example.forgamers.data.model.AllCategoryGame
import com.example.forgamers.data.model.CategoryGame
import com.example.forgamers.ui.viewholder.AllCategoryGameViewHolder
import com.example.forgamers.ui.viewholder.CategoryGameViewHolder

class CategoryGameAdapter(
    private val context: Context,
    private val categoryGameList: List<CategoryGame>
): RecyclerView.Adapter<CategoryGameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryGameViewHolder {

        val layoutView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_category, parent, false)
        return CategoryGameViewHolder(layoutView)

    }

    override fun onBindViewHolder(holder: CategoryGameViewHolder, position: Int) {

        val category = categoryGameList[position]

        holder.nameCat.text = category.categoryName
    }

    override fun getItemCount(): Int = categoryGameList.size
}