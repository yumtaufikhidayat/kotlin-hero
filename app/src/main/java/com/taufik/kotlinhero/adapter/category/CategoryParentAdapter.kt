package com.taufik.kotlinhero.adapter.category

import androidx.recyclerview.widget.RecyclerView
import com.taufik.kotlinhero.databinding.ItemCategoryParentBinding

class CategoryParentAdapter(private val binding: ItemCategoryParentBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(text: String) {
        binding.apply {
            tvCategoryName.text = text
        }
    }
}