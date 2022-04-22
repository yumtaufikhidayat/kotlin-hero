package com.taufik.kotlinhero.ui.about.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.taufik.kotlinhero.data.source.local.About
import com.taufik.kotlinhero.databinding.ItemAboutBinding

class AboutAdapter(
    val clickListener: (Int) -> Unit
) : RecyclerView.Adapter<AboutAdapter.AboutViewHolder>() {

    private val data = ArrayList<About>()

    fun setAboutAuthorData(about: List<About>) {
        data.clear()
        data.addAll(about)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AboutAdapter.AboutViewHolder {
        val inflater = ItemAboutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AboutViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: AboutAdapter.AboutViewHolder, position: Int) {
        holder.onBind(data[position], position)
    }

    override fun getItemCount(): Int = data.size

    inner class AboutViewHolder(private val binding: ItemAboutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(about: About, position: Int) = with(binding) {
            imgAbout.setImageResource(about.icon)
            tvAboutTitle.text = about.title
            tvAboutDesc.text = about.desc
            cardAbout.setOnClickListener {
                clickListener(position)
            }
        }
    }
}