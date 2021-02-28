package com.taufik.kotlinhero.adapter.about

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.taufik.kotlinhero.activity.profile.ProfileActivity
import com.taufik.kotlinhero.databinding.ItemAboutKotlinBinding
import com.taufik.kotlinhero.model.aboutkotlin.AboutKotlin

class AboutKotlinAdapter:RecyclerView.Adapter<AboutKotlinAdapter.MyViewHolder>() {

    private val aboutKotlinList = ArrayList<AboutKotlin>()

    fun setDataAboutKotlin(aboutKotlin: ArrayList<AboutKotlin>) {
        aboutKotlinList.clear()
        aboutKotlinList.addAll(aboutKotlin)
        notifyDataSetChanged()
    }

    inner class MyViewHolder(private val aboutKotlinBinding: ItemAboutKotlinBinding) : RecyclerView.ViewHolder(aboutKotlinBinding.root) {
        fun bind(aboutKotlin: AboutKotlin) {
            aboutKotlinBinding.apply{
                imgAboutKotlin.setImageResource(aboutKotlin.icon)
                tvAboutKotlinDesc.text = aboutKotlin.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = ItemAboutKotlinBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val pos = aboutKotlinList[position]
        holder.bind(pos)
        holder.itemView.setOnClickListener{

            when (position) {
                 0 -> {
                    val intent = Intent(holder.itemView.context, ProfileActivity::class.java)
                    holder.itemView.context.startActivity(intent)
                }

                1 -> {
                    Toast.makeText(holder.itemView.context, pos.name, Toast.LENGTH_SHORT).show()
                }

                else -> Toast.makeText(holder.itemView.context, "Else toast", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount(): Int = aboutKotlinList.size
}