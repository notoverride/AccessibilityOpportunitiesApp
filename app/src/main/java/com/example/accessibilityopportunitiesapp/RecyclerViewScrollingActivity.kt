package com.example.accessibilityopportunitiesapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.accessibilityopportunitiesapp.databinding.RecyclerviewScrollingLayoutBinding
import com.example.accessibilityopportunitiesapp.utils.VIEW_ITEMS
import com.example.accessibilityopportunitiesapp.utils.ViewAdapter

internal class RecyclerViewScrollingActivity : AppCompatActivity() {

    private lateinit var binding: RecyclerviewScrollingLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RecyclerviewScrollingLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.nonScrollingRecyclerView.adapter = ViewAdapter().apply {
            setItems(VIEW_ITEMS)
        }
        binding.scrollingRecyclerView.adapter = ViewAdapter().apply {
            setItems(VIEW_ITEMS)
        }
    }
}