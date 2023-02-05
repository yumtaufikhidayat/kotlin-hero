package com.taufik.kotlinhero.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.taufik.kotlinhero.R
import com.taufik.kotlinhero.databinding.ItemCategoryBinding
import com.taufik.kotlinhero.model.category.CategoryItem

class CourseCategoryAdapter(
    val clickListener: (CategoryItem, Int) -> Unit
) : ListAdapter<CategoryItem, CourseCategoryAdapter.MyViewHolder>(CourseCategoryDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class MyViewHolder(val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: CategoryItem) {
            binding.apply { imgIcon.setImageResource(data.categoryIcon)
                tvCategoryName.text = data.categoryName
                tvCategoryNumber.text = data.categoryNumber
                cardCategoryChild.setCardBackgroundColor(
                    itemView.context.getColor(R.color.white)
                )

                itemView.setOnClickListener {
                    clickListener(data, adapterPosition)
                }
            }
        }
    }

    object CourseCategoryDiffCallback: DiffUtil.ItemCallback<CategoryItem>() {
        override fun areItemsTheSame(
            oldItem: CategoryItem,
            newItem: CategoryItem
        ): Boolean = oldItem.categoryName == newItem.categoryName

        override fun areContentsTheSame(
            oldItem: CategoryItem,
            newItem: CategoryItem
        ): Boolean = oldItem == newItem
    }
}