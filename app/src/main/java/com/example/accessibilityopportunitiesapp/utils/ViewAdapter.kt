package com.example.accessibilityopportunitiesapp.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.accessibilityopportunitiesapp.databinding.ViewHolderItemBinding

class ViewAdapter : RecyclerView.Adapter<ViewAdapter.ViewHolder>() {

    private var items = mutableListOf<ViewItem>()

    fun setItems(viewItems: List<ViewItem>) {
        items = viewItems.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ViewHolderItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setItem(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(
        val binding: ViewHolderItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun setItem(viewItem: ViewItem) {
            binding.itemName.text = viewItem.name
        }
    }
}
