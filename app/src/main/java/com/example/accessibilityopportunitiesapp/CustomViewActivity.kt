package com.example.accessibilityopportunitiesapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.accessibilityopportunitiesapp.databinding.CustomViewActivityLayoutBinding

class CustomViewActivity : AppCompatActivity() {

    private lateinit var binding: CustomViewActivityLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CustomViewActivityLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}