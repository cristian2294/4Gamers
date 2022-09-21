package com.example.forgamers.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.forgamers.data.database.GamersApplication
import com.example.forgamers.data.database.entities.GameFavEntity
import com.example.forgamers.data.model.Game
import com.example.forgamers.databinding.ActivitylGameDetailBinding
import com.example.forgamers.domain.AddFavoriteGameUseCase
import com.example.forgamers.domain.GetAllFavoriteGamesUseCase
import com.example.forgamers.domain.GetGameDetailUseCase
import com.example.forgamers.domain.RemoveFavoriteGameUseCase
import com.example.forgamers.ui.viewmodel.GameDetailViewModel
import com.example.forgamers.ui.viewmodel.GameDetailViewModelFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class GameDetailActivity : AppCompatActivity() {

    // Inject
    @Inject lateinit var getGameDetailUseCase: GetGameDetailUseCase
    @Inject lateinit var addFavoriteGameUseCase: AddFavoriteGameUseCase
    @Inject lateinit var removeFavoriteGameUseCase: RemoveFavoriteGameUseCase
    @Inject lateinit var getAllFavoriteGamesUseCase: GetAllFavoriteGamesUseCase

    // viewBinding
    private lateinit var binding: ActivitylGameDetailBinding

    // Init VM
    private val gameDetailViewModel : GameDetailViewModel by viewModels{
        GameDetailViewModelFactory((application as GamersApplication)
            .repository,
            getGameDetailUseCase,
            addFavoriteGameUseCase,
            removeFavoriteGameUseCase,
            getAllFavoriteGamesUseCase
        )
    }

    // UI variables
    private lateinit var ivGameDetail : ImageView
    private lateinit var tvGameName : TextView
    private lateinit var tvGameGenre : TextView
    private lateinit var tvGameDeveloper : TextView
    private lateinit var tvGameReleaseDate : TextView
    private lateinit var tvGameDescription : TextView
    private lateinit var btnFavGame : FloatingActionButton

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

            btnFavGame.setOnClickListener { addFavoriteGame(game) }
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
        btnFavGame = binding.btnAddFavorites
    }

    private fun addFavoriteGame(game: Game) {
        val gameFavEntity = GameFavEntity(
            game.id.toInt(),
            game.title,
            game.thumbnail,
            game.shortDescription,
            game.genre,
            game.platform,
            game.developer,
            game.gameUrl
        )
        gameDetailViewModel.addFavoriteGame(gameFavEntity)
        val messageSuccess = "Game has been added to your favorites successfully."
        Toast.makeText(this,messageSuccess, Toast.LENGTH_SHORT).show()
    }

}