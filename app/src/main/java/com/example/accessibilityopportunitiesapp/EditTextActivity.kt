package com.example.accessibilityopportunitiesapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.accessibilityopportunitiesapp.databinding.EdittextLayoutBinding

internal class EditTextActivity : AppCompatActivity() {

    private lateinit var binding: EdittextLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = EdittextLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.errorEdittext.error = "Возникла ошибка на стороне сервера"
    }
}