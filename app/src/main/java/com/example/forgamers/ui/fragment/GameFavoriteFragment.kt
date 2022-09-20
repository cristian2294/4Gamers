package com.example.forgamers.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.forgamers.data.repository.GameRoomRepository
import com.example.forgamers.databinding.FragmentGameFavoriteBinding
import com.example.forgamers.domain.AddFavoriteGameUseCase
import com.example.forgamers.domain.GetAllFavoriteGamesUseCase
import com.example.forgamers.domain.GetGameDetailUseCase
import com.example.forgamers.domain.RemoveFavoriteGameUseCase
import com.example.forgamers.ui.adapter.FavoriteGameAdapter
import com.example.forgamers.ui.viewmodel.GameDetailViewModel
import com.example.forgamers.ui.viewmodel.GameDetailViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class GameFavoriteFragment : Fragment() {

    private var _binding: FragmentGameFavoriteBinding? = null
    private val binding get() = _binding!!


    // variables for recyclerView
    private var favGameRv : RecyclerView? = null
    private lateinit var favGameAdapter: FavoriteGameAdapter
    private lateinit var layoutManager: RecyclerView.LayoutManager

    //Inject
    @Inject lateinit var  gameRoomRepository: GameRoomRepository
    @Inject lateinit var getDetailGameUseCase: GetGameDetailUseCase
    @Inject lateinit var addFavoriteGameUseCase: AddFavoriteGameUseCase
    @Inject lateinit var removeFavoriteGameUseCase: RemoveFavoriteGameUseCase
    @Inject lateinit var getAllFavoriteGamesUseCase: GetAllFavoriteGamesUseCase

    //Init VM
    private val gameDetailViewModel : GameDetailViewModel by viewModels {
        GameDetailViewModelFactory(
            gameRoomRepository,
            getDetailGameUseCase,
            addFavoriteGameUseCase,
            removeFavoriteGameUseCase,
            getAllFavoriteGamesUseCase
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding =  FragmentGameFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favGameRv = binding.rvFavoriteGame
        gameDetailViewModel.getAllFavoriteGames().observe(viewLifecycleOwner){ gameFav ->

            favGameRv = binding.rvFavoriteGame
            layoutManager = LinearLayoutManager(view.context)
            favGameRv?.layoutManager = layoutManager
            favGameAdapter = FavoriteGameAdapter(gameDetailViewModel)
            favGameRv?.adapter = favGameAdapter
            favGameAdapter.setData(gameFav)
        }

    }

}