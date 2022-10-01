package com.example.forgamers.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.forgamers.data.model.AllCategoryGame
import com.example.forgamers.data.model.CategoryGame
import com.example.forgamers.databinding.FragmentGameCategoryBinding
import com.example.forgamers.ui.adapter.AllCategoryGameAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GameCategoryFragment : Fragment() {

    private var _binding: FragmentGameCategoryBinding? = null
    private val binding get() = _binding!!

    // variables for recyclerView
    private var allCategoryRv : RecyclerView? = null
    private lateinit var allCategoryGameAdapter: AllCategoryGameAdapter
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

        val allCategory: MutableList<AllCategoryGame> = ArrayList()
        val categoryShooter = listOf(CategoryGame("game1"), CategoryGame("game2"))
        allCategory.add(AllCategoryGame("shooter",categoryShooter))
        val categoryStrategy = listOf(CategoryGame("game1"), CategoryGame("game2"))
        allCategory.add(AllCategoryGame("strategy",categoryStrategy))
        //allCategory.add(CategoryGame("shooter"))
        //allCategory.add(CategoryGame("strategy"))
        //allCategory.add(CategoryGame("MOBA"))

        allCategoryRv = binding.rvParentCategory

        setAllCategoryRecycler(allCategory,view)

    }

    // provides the setup for the all game categories and show it in the recyclerview
    private fun setAllCategoryRecycler(allCategory: List<AllCategoryGame>, view : View){
        layoutManager = LinearLayoutManager(view.context)
        allCategoryRv?.layoutManager = layoutManager
        allCategoryGameAdapter = AllCategoryGameAdapter(view.context,allCategory)
        allCategoryRv?.adapter = allCategoryGameAdapter
    }
}