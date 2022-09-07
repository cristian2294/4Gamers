package com.example.forgamers.ui.view

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.forgamers.R
import com.example.forgamers.databinding.ActivityGameBinding
import com.example.forgamers.ui.fragment.GameCategoryFragment
import com.example.forgamers.ui.fragment.GameFavoriteFragment
import com.example.forgamers.ui.fragment.GameHomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GameActivity : AppCompatActivity() {

    // UI variables
    private lateinit var frameLayout : FrameLayout
    private lateinit var bottomNavMenu: BottomNavigationView

    private lateinit var binding: ActivityGameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // For change limits status bar and navigationView
       /*
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        }
         */

        initUi()
        replaceFragment(GameHomeFragment())

        bottomNavMenu.setOnItemSelectedListener{
            when(it.itemId){
                R.id.home -> replaceFragment(GameHomeFragment())
                R.id.favorites -> replaceFragment(GameFavoriteFragment())
                R.id.category -> replaceFragment(GameCategoryFragment())
            }
            true
        }
    }

    // For inflate all ui variables
    private fun initUi() {
        frameLayout = binding.frameContainer
        bottomNavMenu = binding.gameMenu
    }

    //change between fragments
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(frameLayout.id, fragment)
        fragmentTransaction.commit()
    }

}