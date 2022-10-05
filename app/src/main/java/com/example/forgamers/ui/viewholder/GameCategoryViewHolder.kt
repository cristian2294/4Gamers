package com.example.forgamers.ui.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.forgamers.databinding.TemplateGameCategoryBinding

class GameCategoryViewHolder(view: View): RecyclerView.ViewHolder(view)  {

    private val binding = TemplateGameCategoryBinding.bind(view)

    val nameCat = binding.tvGameCategoryName
}