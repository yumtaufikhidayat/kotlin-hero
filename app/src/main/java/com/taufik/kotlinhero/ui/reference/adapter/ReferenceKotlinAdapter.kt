package com.taufik.kotlinhero.ui.reference.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.taufik.kotlinhero.databinding.ItemAboutKotlinBinding
import com.taufik.kotlinhero.model.aboutkotlin.AboutKotlinItem

class ReferenceKotlinAdapter(
    private val onClickListener: (Int) -> Unit
) : ListAdapter<AboutKotlinItem, ReferenceKotlinAdapter.ReferenceKotlinViewHolder>(ReferenceKotlinDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReferenceKotlinViewHolder {
        return ReferenceKotlinViewHolder(
            ItemAboutKotlinBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ReferenceKotlinViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ReferenceKotlinViewHolder(private val binding: ItemAboutKotlinBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: AboutKotlinItem) {
            binding.apply {
                imgAboutKotlin.setImageResource(data.icon)
                tvAboutKotlinDesc.text = data.name
                itemView.setOnClickListener {
                    onClickListener(adapterPosition)
                }
            }
        }
    }

    object ReferenceKotlinDiffCallback: DiffUtil.ItemCallback<AboutKotlinItem>() {
        override fun areItemsTheSame(
            oldItem: AboutKotlinItem,
            newItem: AboutKotlinItem
        ): Boolean  = oldItem.name == newItem.name

        override fun areContentsTheSame(
            oldItem: AboutKotlinItem,
            newItem: AboutKotlinItem
        ): Boolean = oldItem == newItem
    }
}