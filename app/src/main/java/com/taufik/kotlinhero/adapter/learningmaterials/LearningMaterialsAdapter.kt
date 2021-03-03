package com.taufik.kotlinhero.adapter.learningmaterials

import android.content.Intent
import android.net.Uri
import android.text.*
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.taufik.kotlinhero.databinding.ItemLearningMaterialsBinding
import com.taufik.kotlinhero.model.learningmaterials.LearningMaterialsItem

class LearningMaterialsAdapter:RecyclerView.Adapter<LearningMaterialsAdapter.MyViewHolder>() {

    private val itemList = ArrayList<LearningMaterialsItem>()

    fun setDataIntroduceKotlin(items: ArrayList<LearningMaterialsItem>) {
        itemList.clear()
        itemList.addAll(items)
        notifyDataSetChanged()
    }

    inner class MyViewHolder(val binding: ItemLearningMaterialsBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(learningMaterialsItem: LearningMaterialsItem) {
            binding.apply {
                tvIntroduceKotlinTitleNumber.text = learningMaterialsItem.titleNumber
                tvIntroduceKotlinTitleName.text = learningMaterialsItem.titleName
                tvDesc.text = learningMaterialsItem.description
                tvVideoUrl.text = learningMaterialsItem.videoUrl
            }
        }
    }

    private fun TextView.makeLinks(vararg links: Pair<String, View.OnClickListener>){
        val spannableString = SpannableString(this.text)
        var startIndexOfLink = -1

        for (link in links) {
            val clickableSpan = object : ClickableSpan(){

                override fun updateDrawState(ds: TextPaint) {
                    ds.color = ds.linkColor
                    ds.isUnderlineText = false
                }

                override fun onClick(view: View) {
                    Selection.setSelection((view as TextView).text as Spannable, 0)
                    view.invalidate()
                    link.second.onClick(view)
                }
            }

            startIndexOfLink = this.text.toString().indexOf(link.first, startIndexOfLink + 1)
            spannableString.setSpan(
                clickableSpan,
                startIndexOfLink,
                startIndexOfLink + link.first.length,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }

        this.movementMethod = LinkMovementMethod.getInstance()
        this.setText(spannableString, TextView.BufferType.SPANNABLE)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = ItemLearningMaterialsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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

            val isChecked: Boolean
            
            if (isExpandable) {
                toggleExpand.isChecked = true
                isChecked = true
            } else {
                toggleExpand.isChecked = false
                isChecked = false
            }

            toggleExpand.setOnClickListener{
                pos.isExpandable = !pos.isExpandable
                if (isChecked) {
                    pos.isExpandable
                } else {
                    !pos.isExpandable
                }
                notifyItemChanged(position)
            }

            tvVideoUrl.makeLinks(Pair(pos.videoUrl, View.OnClickListener {
                try {
                    val intent =
                        Intent(Intent.ACTION_VIEW, Uri.parse(pos.videoUrl))
                    holder.itemView.context.startActivity(
                        Intent.createChooser(
                            intent,
                            "Open with:"
                        )
                    )
                } catch (e: Exception) {
                    Toast.makeText(
                        holder.itemView.context,
                        "Silakan install browser terlebih dulu.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }))
        }
    }

    override fun getItemCount(): Int = itemList.size
}