package com.example.mixweather.landing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.mixweather.R
import com.example.mixweather.databinding.ActivityLanindingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LandingActivity : AppCompatActivity() {

    private var binding: ActivityLanindingBinding? = null

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLanindingBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        initNav(savedInstanceState)
    }

    private fun initNav(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            val hostFragment = NavHostFragment.create(
                R.navigation.weather_navigation
            )
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, hostFragment)
                .setPrimaryNavigationFragment(hostFragment)
                .commitNow()
            navController = hostFragment.navController
        }
    }
}