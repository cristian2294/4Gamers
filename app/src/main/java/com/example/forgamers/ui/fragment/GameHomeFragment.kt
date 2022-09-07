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
import com.example.forgamers.databinding.FragmentGameListBinding
import com.example.forgamers.ui.adapter.GameAdapter
import com.example.forgamers.ui.viewmodel.GameViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class GameHomeFragment : Fragment() {

    private var _binding: FragmentGameListBinding? = null
    private val binding get() = _binding!!

    // variables for recyclerView
    private var gameRv : RecyclerView? = null
    private lateinit var gameAdapter: GameAdapter
    private lateinit var layoutManager: RecyclerView.LayoutManager

    // Init VM
    private val gameViewModel : GameViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding =  FragmentGameListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        gameRv = binding.rvGame
        gameViewModel.getLiveGames()

        // Create the observer which updates the UI.
        val gameObserver = Observer<List<Game>>{  gameResponse ->

            // Update the UI for show the data in the recyclerview
            layoutManager = LinearLayoutManager(view.context)
            gameRv?.layoutManager = layoutManager
            gameAdapter = GameAdapter(view.context,gameResponse)
            gameRv?.adapter = gameAdapter
        }

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        gameViewModel.gameModel.observe(viewLifecycleOwner,gameObserver)
    }
}