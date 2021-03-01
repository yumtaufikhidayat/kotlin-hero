package com.taufik.kotlinhero.adapter.category

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.taufik.kotlinhero.R
import com.taufik.kotlinhero.databinding.ItemCategoryBinding
import com.taufik.kotlinhero.model.category.CategoryItem

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {

    private val categoryList = ArrayList<CategoryItem>()

    fun setDataCategoryList(category: ArrayList<CategoryItem>) {
        categoryList.clear()
        categoryList.addAll(category)
        notifyDataSetChanged()
    }

    inner class MyViewHolder(val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(categoryItem: CategoryItem) {
            binding.apply {
                imgIcon.setImageResource(categoryItem.categoryIcon)
                tvCategoryName.text = categoryItem.categoryName
                tvCategoryNumber.text = categoryItem.categoryNumber
                cardCategoryChild.setOnClickListener {
                    Toast.makeText(itemView.context, categoryItem.categoryName, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.MyViewHolder {
        val view = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryAdapter.MyViewHolder, position: Int) {
        val pos = categoryList[position]
        holder.bind(pos)

        holder.binding.apply {
            cardCategoryChild.setCardBackgroundColor(
                holder.itemView.context.getColor(
                    R.color.white
                )
            )
        }

        holder.itemView.setOnClickListener{
            Toast.makeText(holder.itemView.context, pos.categoryName, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount() : Int = categoryList.size
}