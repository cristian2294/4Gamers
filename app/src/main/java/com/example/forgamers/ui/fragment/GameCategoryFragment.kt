package com.example.forgamers.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.forgamers.data.model.GameCategoryCatalog
import com.example.forgamers.data.model.GameCategory
import com.example.forgamers.databinding.FragmentGameCategoryBinding
import com.example.forgamers.ui.adapter.GameCategoryCatalogAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GameCategoryFragment : Fragment() {

    private var _binding: FragmentGameCategoryBinding? = null
    private val binding get() = _binding!!

    // variables for recyclerView
    private var allCategoryRv : RecyclerView? = null
    private lateinit var gameCategoryCatalogAdapter: GameCategoryCatalogAdapter
    private lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding =  FragmentGameCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val allCategory: MutableList<GameCategoryCatalog> = ArrayList()
        val categoryShooter = listOf(GameCategory("game1"), GameCategory("game2"))
        allCategory.add(GameCategoryCatalog("shooter",categoryShooter))
        val categoryStrategy = listOf(GameCategory("game1"), GameCategory("game2"), GameCategory("game3"))
        allCategory.add(GameCategoryCatalog("strategy",categoryStrategy))

        allCategoryRv = binding.rvGameCategoryCatalog
        setAllCategoryCatalogRecycler(allCategory,view)
    }

    // provides the setup for the all game categories and show it in the recyclerview
    private fun setAllCategoryCatalogRecycler(listGameCategoryCatalog: List<GameCategoryCatalog>, view : View){
        layoutManager = LinearLayoutManager(view.context)
        allCategoryRv?.layoutManager = layoutManager
        gameCategoryCatalogAdapter = GameCategoryCatalogAdapter(view.context,listGameCategoryCatalog)
        allCategoryRv?.adapter = gameCategoryCatalogAdapter
    }
}