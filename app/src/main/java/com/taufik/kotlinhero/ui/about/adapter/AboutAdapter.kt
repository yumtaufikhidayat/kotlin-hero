package com.taufik.kotlinhero.ui.about.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.taufik.kotlinhero.data.local.About
import com.taufik.kotlinhero.databinding.ItemAboutBinding

class AboutAdapter(
    val clickListener: (Int) -> Unit
) : ListAdapter<About, AboutAdapter.AboutViewHolder>(AboutDiffCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AboutAdapter.AboutViewHolder {
        return AboutViewHolder(ItemAboutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: AboutAdapter.AboutViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class AboutViewHolder(private val binding: ItemAboutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(about: About) {
            binding.apply {
                imgAbout.setImageResource(about.icon)
                tvAboutTitle.text = about.title
                tvAboutDesc.text = about.desc
                cardAbout.setOnClickListener {
                    clickListener(adapterPosition)
                }
            }
        }
    }

    object AboutDiffCallback: DiffUtil.ItemCallback<About>() {
        override fun areItemsTheSame(
            oldItem: About,
            newItem: About
        ): Boolean = oldItem.title == newItem.title

        override fun areContentsTheSame(
            oldItem: About,
            newItem: About
        ): Boolean = oldItem == newItem
    }
}