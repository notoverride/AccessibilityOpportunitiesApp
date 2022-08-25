package com.example.accessibilityopportunitiesapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.AccessibilityDelegateCompat
import androidx.core.view.ViewCompat
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat
import com.example.accessibilityopportunitiesapp.databinding.CustomActionsLayoutBinding

internal class ActionsActivity : AppCompatActivity() {

    private lateinit var binding: CustomActionsLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CustomActionsLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val defaultActionsButton = binding.defaultActionsButton
        val noActionButton = binding.noActionsButton
        defaultActionsButton.setOnClickListener {
        }
        defaultActionsButton.setOnLongClickListener {
            true
        }
        ViewCompat.setAccessibilityDelegate(noActionButton, object : AccessibilityDelegateCompat() {
            override fun onInitializeAccessibilityNodeInfo(host: View, info: AccessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(host, info)
                info.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK)
                info.isClickable = false
            }
        })
    }
}
