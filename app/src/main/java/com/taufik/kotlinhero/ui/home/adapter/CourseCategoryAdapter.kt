package com.taufik.kotlinhero.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.taufik.kotlinhero.R
import com.taufik.kotlinhero.databinding.ItemCategoryBinding
import com.taufik.kotlinhero.model.response.ListCategoriesData

class CourseCategoryAdapter(
    val clickListener: (ListCategoriesData) -> Unit
) : ListAdapter<ListCategoriesData, CourseCategoryAdapter.MyViewHolder>(CourseCategoryDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class MyViewHolder(val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ListCategoriesData) {
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
                    clickListener(data)
                }
            }
        }
    }

    object CourseCategoryDiffCallback: DiffUtil.ItemCallback<ListCategoriesData>() {
        override fun areItemsTheSame(
            oldItem: ListCategoriesData,
            newItem: ListCategoriesData
        ): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: ListCategoriesData,
            newItem: ListCategoriesData
        ): Boolean = oldItem == newItem
    }
}