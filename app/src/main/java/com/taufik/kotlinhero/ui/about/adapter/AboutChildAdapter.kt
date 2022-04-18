package com.taufik.kotlinhero.ui.about.adapter

import androidx.recyclerview.widget.RecyclerView
import com.taufik.kotlinhero.data.source.local.About
import com.taufik.kotlinhero.databinding.ItemAboutChildBinding

class AboutChildAdapter(
    private val binding: ItemAboutChildBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(item: About) = with(binding){
        tvAboutTitle.text = item.title
        tvAboutDesc.text = item.desc
    }
}