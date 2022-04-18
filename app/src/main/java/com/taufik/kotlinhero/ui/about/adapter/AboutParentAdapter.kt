package com.taufik.kotlinhero.ui.about.adapter

import androidx.recyclerview.widget.RecyclerView
import com.taufik.kotlinhero.databinding.ItemAboutParentBinding

class AboutParentAdapter(
    private val binding: ItemAboutParentBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(text: String) = with(binding) {
        tvAboutCategory.text = text
    }
}