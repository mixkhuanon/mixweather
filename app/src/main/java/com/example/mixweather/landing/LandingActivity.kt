package com.example.mixweather.landing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mixweather.databinding.ActivityLanindingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LandingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLanindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLanindingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}