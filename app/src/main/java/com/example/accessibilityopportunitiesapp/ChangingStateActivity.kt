package com.example.accessibilityopportunitiesapp

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.AccessibilityDelegateCompat
import androidx.core.view.ViewCompat
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat
import com.example.accessibilityopportunitiesapp.databinding.ChangingStateLayoutBinding

internal class ChangingStateActivity : AppCompatActivity() {

    private lateinit var binding: ChangingStateLayoutBinding

    private var counter = 0
    private var baseItemSelected = false
    private var customItemSelected = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ChangingStateLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            binding.value.text = (++counter).toString()
        }
        val favoriteButtonDefault = binding.favoriteButtonDefault
        val favoriteButtonCustom = binding.favoriteButtonCustom
        favoriteButtonDefault.setOnClickListener {
            baseItemSelected = !baseItemSelected
            setDrawable(favoriteButtonDefault, baseItemSelected)
        }

        setCustomAccessibilityForButton(favoriteButtonCustom)
        favoriteButtonCustom.setOnClickListener {
            customItemSelected = !customItemSelected
            setDrawable(favoriteButtonCustom, customItemSelected)
            setCustomAccessibilityForButton(favoriteButtonCustom)
        }
    }

    private fun setCustomAccessibilityForButton(button: ImageButton) {
        button.contentDescription = getString(
            if (customItemSelected) {
                R.string.content_description_favorite
            } else {
                R.string.content_description_not_favorite
            }
        )

        ViewCompat.setAccessibilityDelegate(button, object : AccessibilityDelegateCompat() {
            override fun onInitializeAccessibilityNodeInfo(v: View, info: AccessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(v, info)
                val clickAction = AccessibilityNodeInfoCompat.AccessibilityActionCompat(
                    AccessibilityNodeInfoCompat.ACTION_CLICK, getString(
                        if (customItemSelected) {
                            R.string.content_description_action_remove_from_favorites
                        } else {
                            R.string.content_description_action_favorite
                        }
                    )
                )
                info.addAction(clickAction)
            }
        })
    }

    private fun setDrawable(imageButton: ImageButton, selected: Boolean) {
        imageButton.setImageDrawable(
            ContextCompat.getDrawable(
                this,
                if (selected) {
                    R.drawable.ic_fill_like
                } else {
                    R.drawable.ic_like
                }
            )
        )
    }
}
