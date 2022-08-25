package com.example.accessibilityopportunitiesapp.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Switch
import androidx.core.view.AccessibilityDelegateCompat
import androidx.core.view.ViewCompat
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat
import com.example.accessibilityopportunitiesapp.R
import com.example.accessibilityopportunitiesapp.databinding.CustomSwitchLayoutBinding
import com.google.android.material.color.MaterialColors
import com.google.android.material.R as materialR

class CustomSwitch @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    private val binding = CustomSwitchLayoutBinding.inflate(
        LayoutInflater.from(context), this, true
    )

    init {
        initListeners()
        binding.firstTariffButton.performClick()
        setAccessibility()
    }

    private fun initListeners() = with(binding) {
        firstTariffButton.setOnClickListener {
            firstTariffButton.select()
            secondTariffButton.unselect()
            thirdTariffLabel.unselect()
            setStateDescription()
        }
        secondTariffButton.setOnClickListener {
            secondTariffButton.select()
            firstTariffButton.unselect()
            thirdTariffLabel.unselect()
            setStateDescription()
        }
        thirdTariffLabel.setOnClickListener {
            thirdTariffLabel.select()
            firstTariffButton.unselect()
            secondTariffButton.unselect()
            setStateDescription()
        }
    }

    private fun setStateDescription() {
        ViewCompat.setStateDescription(
            binding.root,
            context.getString(
                when {
                    binding.secondTariffButton.isSelected -> {
                        R.string.second_tariff_label
                    }
                    binding.thirdTariffLabel.isSelected -> {
                        R.string.third_tariff_label
                    }
                    else -> {
                        R.string.first_tariff_label
                    }
                }
            )
        )
    }

    private fun setAccessibility() = with(binding) {
        ViewCompat.replaceAccessibilityAction(
            root,
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK,
            context.getString(R.string.custom_switch_action_name)
        ) { _, _ ->
            when {
                secondTariffButton.isSelected -> {
                    thirdTariffLabel.performClick()
                }
                thirdTariffLabel.isSelected -> {
                    firstTariffButton.performClick()
                }
                else -> {
                    secondTariffButton.performClick()
                }
            }
            true
        }

        ViewCompat.setAccessibilityDelegate(
            root,
            object : AccessibilityDelegateCompat() {
                override fun onInitializeAccessibilityNodeInfo(
                    host: View,
                    info: AccessibilityNodeInfoCompat
                ) {
                    super.onInitializeAccessibilityNodeInfo(host, info)
                    info.className = Switch::class.java.name
                }
            }
        )
    }

    private fun Button.select() {
        isSelected = true
        setTextColor(
            MaterialColors.getColor(
                this,
                materialR.attr.colorOnPrimary
            )
        )
    }

    private fun Button.unselect() {
        isSelected = false
        setTextColor(
            MaterialColors.getColor(
                this,
                materialR.attr.colorPrimary
            )
        )
    }
}