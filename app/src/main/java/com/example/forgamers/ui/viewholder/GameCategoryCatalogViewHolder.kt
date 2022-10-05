package com.example.forgamers.ui.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.forgamers.databinding.TemplateRowGameCategoryCatalogBinding


class GameCategoryCatalogViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = TemplateRowGameCategoryCatalogBinding.bind(view)

    val tvCategoryCatalogGameName = binding.tvNameCategory
    val rvCategoryCatalogGame = binding.rvGameCategory
}