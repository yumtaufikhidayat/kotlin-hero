package com.taufik.kotlinhero.ui.listcourses.adapter

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

class KotlinBasicAdapter:RecyclerView.Adapter<KotlinBasicAdapter.MyViewHolder>() {

    private val itemList = ArrayList<LearningMaterialsItem>()

    fun setDataIntroduceKotlin(items: ArrayList<LearningMaterialsItem>) {
        itemList.clear()
        itemList.addAll(items)
        notifyDataSetChanged()
    }

    inner class MyViewHolder(val binding: ItemLearningMaterialsBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(learningMaterialsItem: LearningMaterialsItem) {
            binding.apply {
                tvLearningMaterialsTitleNumber.text = learningMaterialsItem.titleNumber
                tvLearningMaterialsTitleName.text = learningMaterialsItem.titleName
                tvDesc.text = learningMaterialsItem.description
                tvVideoUrlLearningMaterials.text = learningMaterialsItem.videoUrl
                videoLearningMaterials.settings.javaScriptEnabled = true
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
            expandableLearningMaterialsLayout.visibility =
                    if (isExpandable) {
                        View.VISIBLE
                    } else {
                        View.GONE
                    }

            val isChecked: Boolean
            
            if (!isExpandable) {
                toggleExpand.isChecked = false
                isChecked = false
            } else {
                toggleExpand.isChecked = true
                isChecked = true
            }

            toggleExpand.setOnClickListener {
                pos.isExpandable = !pos.isExpandable
                if (isChecked) {
                    pos.isExpandable
                } else {
                    !pos.isExpandable
                }
                notifyItemChanged(position)
            }

            constraintLearningMaterials.setOnClickListener {
                pos.isExpandable = !pos.isExpandable
                if (isChecked) {
                    pos.isExpandable
                } else {
                    !pos.isExpandable
                }
                notifyItemChanged(position)
            }

            videoLearningMaterials.loadData(pos.embedVideoUrl, "text/html" , "utf-8")

//            val mediaController = MediaController(holder.itemView.context)
//            mediaController.setAnchorView(videoLearningMaterials)
//
//            val onlineUrl = Uri.parse(pos.embedVideoUrl)
//            videoLearningMaterials.setMediaController(mediaController)
//            videoLearningMaterials.setVideoURI(onlineUrl)
//            videoLearningMaterials.requestFocus()

//            videoLearningMaterials.addYouTubePlayerListener(object :
//                AbstractYouTubePlayerListener() {
//                override fun onReady(youTubePlayer: YouTubePlayer) {
//                    val videoId = pos.embedVideoUrl
//                    youTubePlayer.loadVideo(videoId, 0F)
//                }
//            })

            tvVideoUrlLearningMaterials.makeLinks(Pair(pos.videoUrl, View.OnClickListener {
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