package com.taufik.kotlinhero.adapter.about

import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
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
                    try {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://kotlinlang.org/docs/home.html"))
                        holder.itemView.context.startActivity(Intent.createChooser(intent, "Open with:"))
                    } catch (e: Exception) {
                        Toast.makeText(holder.itemView.context, "Silakan install browser terlebih dulu", Toast.LENGTH_SHORT).show()
                        Log.e("errorLink", "setViewModel: ${e.localizedMessage}")
                    }
                }

                1 -> {
                    try {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://kotlinlang.org/docs/coding-conventions.html"))
                        holder.itemView.context.startActivity(Intent.createChooser(intent, "Open with:"))
                    } catch (e: Exception) {
                        Toast.makeText(holder.itemView.context, "Silakan install browser terlebih dulu", Toast.LENGTH_SHORT).show()
                        Log.e("errorLink", "setViewModel: ${e.localizedMessage}")
                    }
                }

                2 -> {
                    try {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://kotlinlang.org/docs/contribute.html"))
                        holder.itemView.context.startActivity(Intent.createChooser(intent, "Open with:"))
                    } catch (e: Exception) {
                        Toast.makeText(holder.itemView.context, "Silakan install browser terlebih dulu", Toast.LENGTH_SHORT).show()
                        Log.e("errorLink", "setViewModel: ${e.localizedMessage}")
                    }
                }

                else -> Toast.makeText(holder.itemView.context, "Else toast", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount(): Int = aboutKotlinList.size
}