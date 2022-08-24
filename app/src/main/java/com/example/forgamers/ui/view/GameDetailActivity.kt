package com.example.forgamers.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.forgamers.data.model.Game
import com.example.forgamers.databinding.ActivitylGameDetailBinding
import com.example.forgamers.domain.GetGameDetailUseCase
import com.example.forgamers.ui.viewmodel.GameDetailViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class GameDetailActivity : AppCompatActivity() {

    // viewBinding
    private lateinit var binding: ActivitylGameDetailBinding

    // Init VM
    private val gameDetailViewModel : GameDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitylGameDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        val gameId = intent.getStringExtra("gameId")!!

        /*
        gameDetailViewModel.getGameDetail(gameId)

        // Create the observer which updates the UI.
        val gameObserver = Observer<Game> { game ->
        }
       */
    }
}