package com.example.forgamers.ui.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.forgamers.databinding.ItemRowCategoryBinding

class CategoryGameViewHolder(view: View): RecyclerView.ViewHolder(view)  {

    private val binding = ItemRowCategoryBinding.bind(view)

    val nameCat = binding.tvNameC
}