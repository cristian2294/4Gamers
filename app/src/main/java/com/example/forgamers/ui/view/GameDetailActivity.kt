package com.example.forgamers.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.forgamers.data.model.Game
import com.example.forgamers.databinding.ActivitylGameDetailBinding
import com.example.forgamers.ui.viewmodel.GameDetailViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class GameDetailActivity : AppCompatActivity() {

    // viewBinding
    private lateinit var binding: ActivitylGameDetailBinding

    // Init VM
    private val gameDetailViewModel : GameDetailViewModel by viewModels()

    // UI variables
    private lateinit var ivGameDetail : ImageView
    private lateinit var tvGameName : TextView
    private lateinit var tvGameGenre : TextView
    private lateinit var tvGameDeveloper : TextView
    private lateinit var tvGameReleaseDate : TextView
    private lateinit var tvGameDescription : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitylGameDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            window.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        }
         */

        initUI()

        val intent = intent
        val gameId = intent.getStringExtra("gameId")!!

        gameDetailViewModel.getGameDetail(gameId)

        // Create the observer which updates the UI.
        val gameObserver = Observer<Game> { game ->

            tvGameName.text = game.title
            tvGameGenre.text = game.genre
            tvGameDeveloper.text = game.developer
            tvGameReleaseDate.text = game.releaseDate.toString()
            tvGameDescription.text = game.description


            val ulrImage = game.thumbnail
            Glide.with(this)
                .load(ulrImage)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(ivGameDetail)
        }

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        gameDetailViewModel.gameModel.observe(this, gameObserver)
    }

    private fun initUI() {
        ivGameDetail = binding.ivGameDetail
        tvGameName = binding.tvGameDetailName
        tvGameGenre = binding.tvGameDetailGenre
        tvGameDeveloper = binding.tvGameDetailDeveloper
        tvGameReleaseDate = binding.tvGameDetailReleaseDate
        tvGameDescription = binding.tvGameDetailDescription
    }
}