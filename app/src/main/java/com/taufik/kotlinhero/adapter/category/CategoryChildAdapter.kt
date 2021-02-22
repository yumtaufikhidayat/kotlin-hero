package com.taufik.kotlinhero.adapter.category

import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.taufik.kotlinhero.databinding.ItemCategoryChildBinding
import com.taufik.kotlinhero.model.category.CategoryItem

class CategoryChildAdapter(private val binding: ItemCategoryChildBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(categoryItem : CategoryItem) {
        binding.apply {
            tvCategoryName.text = categoryItem.categoryName
            cardCategoryChild.setOnClickListener{
                Toast.makeText(itemView.context, categoryItem.categoryName, Toast.LENGTH_SHORT).show()
            }
        }
    }
}