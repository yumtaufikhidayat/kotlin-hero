package com.taufik.kotlinhero.activity.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.taufik.kotlinhero.R
import com.taufik.kotlinhero.adapter.about.AboutKotlinAdapter
import com.taufik.kotlinhero.adapter.category.CategoryAdapter
import com.taufik.kotlinhero.data.MainCategory
import com.taufik.kotlinhero.databinding.ActivityMainBinding
import com.taufik.kotlinhero.model.aboutkotlin.AboutKotlin

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var aboutKotlinAdapter: AboutKotlinAdapter
    private lateinit var aboutKotlinData: ArrayList<AboutKotlin>
    private var categoryData = listOf<Any>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setAboutKotlinData()

        setRecyclerViewAboutKotlin()

        setRecyclerViewCategory()

        setProfileOnClick()
    }

    private fun setAboutKotlinData() {

        aboutKotlinData = ArrayList()

        val list: MutableList<AboutKotlin> = mutableListOf()
        list.add(AboutKotlin(R.drawable.ic_why, "Mengapa Kotlin?"))
        list.add(AboutKotlin(R.drawable.ic_docs, "Dokumentasi\nKotlin"))
        list.add(AboutKotlin(R.drawable.ic_roadmap, "Roadmap Kotlin"))

        aboutKotlinData.addAll(list)
    }

    private fun setRecyclerViewAboutKotlin() {

        aboutKotlinAdapter = AboutKotlinAdapter()
        aboutKotlinAdapter.notifyDataSetChanged()

        binding.apply {
            rvAboutKotlin.layoutManager = GridLayoutManager(this@MainActivity, 3)
            rvAboutKotlin.setHasFixedSize(true)
            aboutKotlinAdapter.setDataAboutKotlin(aboutKotlinData)
            rvAboutKotlin.adapter = aboutKotlinAdapter
        }
    }

    private fun setRecyclerViewCategory() {

        categoryData = MainCategory.category
        categoryAdapter = CategoryAdapter(categoryData)

        binding.apply {
            rvCategoryParent.layoutManager = LinearLayoutManager(this@MainActivity)
            rvCategoryParent.setHasFixedSize(true)
            rvCategoryParent.adapter = categoryAdapter
        }
    }

    private fun setProfileOnClick() {
        binding.apply {
            imgProfile.setOnClickListener{
                Toast.makeText(this@MainActivity, getString(R.string.tvProfile), Toast.LENGTH_SHORT).show()
            }
        }
    }
}