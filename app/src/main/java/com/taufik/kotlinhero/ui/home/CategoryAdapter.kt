package com.taufik.kotlinhero.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.taufik.kotlinhero.R
import com.taufik.kotlinhero.databinding.ItemCategoryBinding
import com.taufik.kotlinhero.model.category.CategoryItem

class CategoryAdapter(val clickListener: (CategoryItem) -> Unit) : RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {

    private val categoryList = ArrayList<CategoryItem>()

    fun setDataCategoryList(category: ArrayList<CategoryItem>) {
        categoryList.clear()
        categoryList.addAll(category)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
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
            clickListener(pos)
        }
    }

    override fun getItemCount() : Int = categoryList.size

    inner class MyViewHolder(val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(categoryItem: CategoryItem) {
            binding.apply {
                imgIcon.setImageResource(categoryItem.categoryIcon)
                tvCategoryName.text = categoryItem.categoryName
                tvCategoryNumber.text = categoryItem.categoryNumber
            }
        }
    }
}