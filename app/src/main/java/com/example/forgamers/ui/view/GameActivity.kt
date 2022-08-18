package com.example.forgamers.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.forgamers.databinding.ActivityGameBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}