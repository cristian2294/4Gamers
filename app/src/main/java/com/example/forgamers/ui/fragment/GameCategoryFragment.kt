package com.example.forgamers.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.forgamers.data.model.Game
import com.example.forgamers.data.model.GameCategoryCatalog
import com.example.forgamers.databinding.FragmentGameCategoryBinding
import com.example.forgamers.ui.adapter.GameCategoryCatalogAdapter
import com.example.forgamers.ui.viewmodel.GameCategoryViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.collections.ArrayList

@Suppress("DEPRECATION")
@AndroidEntryPoint
class GameCategoryFragment : Fragment() {

    private var _binding: FragmentGameCategoryBinding? = null
    private val binding get() = _binding!!

    // variables for recyclerView
    private var allCategoryRv : RecyclerView? = null
    private lateinit var gameCategoryCatalogAdapter: GameCategoryCatalogAdapter
    private lateinit var layoutManager: RecyclerView.LayoutManager

    private lateinit var gameCategoryObserver : Observer<List<Game>>

    //Init VM
    private val gameCategoryViewModel : GameCategoryViewModel by viewModels()

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

        allCategoryRv = binding.rvGameCategoryCatalog

        val categoryCatalogList: MutableList<GameCategoryCatalog> = ArrayList()
        gameCategoryViewModel.getAllGameCategories()

        val gameCatalogObserver = Observer<List<String>>{ catalogResponse ->
            catalogResponse.forEach {

                gameCategoryViewModel.getGamesByCategory(it)

                gameCategoryObserver = Observer<List<Game>>{ gameCategoryResponse ->
                    categoryCatalogList.add(GameCategoryCatalog(it,gameCategoryResponse))
                    setAllCategoryCatalogRecycler(categoryCatalogList,view)
                }
            }
            // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
            gameCategoryViewModel.gameCategoryModel.observe(viewLifecycleOwner,gameCategoryObserver)
        }
        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        gameCategoryViewModel.gameCatalogModel.observe(viewLifecycleOwner,gameCatalogObserver)
    }

    // provides the setup for the all game categories and show it in the recyclerview
    private fun setAllCategoryCatalogRecycler(listGameCategoryCatalog: List<GameCategoryCatalog>, view : View){
        layoutManager = LinearLayoutManager(view.context)
        allCategoryRv?.layoutManager = layoutManager
        gameCategoryCatalogAdapter = GameCategoryCatalogAdapter(view.context,listGameCategoryCatalog)
        allCategoryRv?.adapter = gameCategoryCatalogAdapter
    }
}