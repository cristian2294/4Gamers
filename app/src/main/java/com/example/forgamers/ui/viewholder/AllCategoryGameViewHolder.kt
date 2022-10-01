package com.example.forgamers.ui.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.forgamers.databinding.FragmentGameCategoryBinding


class AllCategoryGameViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = FragmentGameCategoryBinding.bind(view)

    var tvCategoryGameName = binding.tvCategoryGameName
    var rvCategoryGame = binding.rvParentCategory
}