package com.taufik.kotlinhero.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.taufik.kotlinhero.R
import com.taufik.kotlinhero.databinding.ItemCategoryBinding
import com.taufik.kotlinhero.model.response.ListCoursesItem

class CourseCategoryAdapter(
    val clickListener: (ListCoursesItem, Int) -> Unit
) : ListAdapter<ListCoursesItem, CourseCategoryAdapter.MyViewHolder>(CourseCategoryDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position), position)
    }

    inner class MyViewHolder(val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ListCoursesItem, position: Int) {
            binding.apply {
                tvCategoryName.text = data.name
                tvCategoryNumber.text = itemView.context.getString(
                    R.string.tvCoursesNumber,
                    data.courses
                )
                cardCategoryChild.setCardBackgroundColor(
                    itemView.context.getColor(R.color.white)
                )

                itemView.setOnClickListener {
                    clickListener(data, position)
                }
            }
        }
    }

    object CourseCategoryDiffCallback: DiffUtil.ItemCallback<ListCoursesItem>() {
        override fun areItemsTheSame(
            oldItem: ListCoursesItem,
            newItem: ListCoursesItem
        ): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: ListCoursesItem,
            newItem: ListCoursesItem
        ): Boolean = oldItem == newItem
    }
}