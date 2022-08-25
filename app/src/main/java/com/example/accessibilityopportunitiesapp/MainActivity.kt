package com.example.accessibilityopportunitiesapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.accessibilityopportunitiesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.priorityButton.setOnClickListener { startActivity(Intent(this, PriorityActivity::class.java)) }
        binding.edittextButton.setOnClickListener { startActivity(Intent(this, EditTextActivity::class.java)) }
        binding.rolesAndActionsButton.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    ActionsActivity::class.java
                )
            )
        }
        binding.customSwitchButton.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    CustomViewActivity::class.java
                )
            )
        }
        binding.stateChangesButton.setOnClickListener { startActivity(Intent(this, ChangingStateActivity::class.java)) }
        binding.recyclerViewScrollingButton.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    RecyclerViewScrollingActivity::class.java
                )
            )
        }
    }
}