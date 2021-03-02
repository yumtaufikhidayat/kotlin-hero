package com.taufik.kotlinhero.adapter.learningmaterials

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.taufik.kotlinhero.databinding.ItemIntroduceKotlinBinding
import com.taufik.kotlinhero.model.learningmaterials.LearningMaterialsItem

class IntroduceKotlinAdapter:RecyclerView.Adapter<IntroduceKotlinAdapter.MyViewHolder>() {

    private val itemList = ArrayList<LearningMaterialsItem>()

    fun setDataIntroduceKotlin(items: ArrayList<LearningMaterialsItem>) {
        itemList.clear()
        itemList.addAll(items)
        notifyDataSetChanged()
    }

    inner class MyViewHolder(val binding: ItemIntroduceKotlinBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(learningMaterialsItem: LearningMaterialsItem) {
            binding.apply {
                tvIntroduceKotlinTitle.text = learningMaterialsItem.title
                tvDesc.text = learningMaterialsItem.description
                tvDocsUrl.text = learningMaterialsItem.documentationUrl
                tvVideoUrl.text = learningMaterialsItem.videoUrl
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = ItemIntroduceKotlinBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val pos = itemList[position]
        holder.bind(pos)

        val isExpandable: Boolean = pos.isExpandable

        holder.binding.apply {
            expandableIntroduceKotlinLayout.visibility =
                    if (isExpandable) {
                        View.VISIBLE
                    } else {
                        View.GONE
                    }

            constraintIntroduce.setOnClickListener{
                pos.isExpandable = !pos.isExpandable
                notifyItemChanged(position)
            }

            imgArrowDropdown.setOnClickListener{
                pos.isExpandable = !pos.isExpandable
                notifyItemChanged(position)
            }
        }
    }

    override fun getItemCount(): Int = itemList.size
}