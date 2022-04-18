package com.taufik.kotlinhero.ui.about.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.taufik.kotlinhero.data.source.local.About
import com.taufik.kotlinhero.databinding.ItemAboutChildBinding
import com.taufik.kotlinhero.databinding.ItemAboutParentBinding
import java.lang.IllegalArgumentException

class AboutAdapter(
    private val data: List<Any>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return when (viewType) {
            PARENT_CATEGORY -> AboutParentAdapter(
                ItemAboutParentBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    ), parent, false
                )
            )

            CHILD_CATEGORY -> AboutChildAdapter(
                ItemAboutChildBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    ), parent, false
                )
            )

            else -> throw IllegalArgumentException("Undefined view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            PARENT_CATEGORY -> {
                val parentAdapter = holder as AboutParentAdapter
                parentAdapter.onBind(data[position] as String)
            }

            CHILD_CATEGORY -> {
                val childAdapter = holder as AboutChildAdapter
                childAdapter.onBind(data[position] as About)
            }

            else -> throw IllegalArgumentException("Undefined view type")
        }
    }

    override fun getItemCount(): Int = data.size

    override fun getItemViewType(position: Int): Int {
        return when (data[position]) {
            is String -> PARENT_CATEGORY
            is About -> CHILD_CATEGORY
            else -> throw IllegalArgumentException("Undefined view type")
        }
    }

    companion object {
        private const val PARENT_CATEGORY = 0
        private const val CHILD_CATEGORY = 1
    }
}