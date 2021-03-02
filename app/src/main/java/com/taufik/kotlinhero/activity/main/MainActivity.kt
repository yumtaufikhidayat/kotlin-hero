package com.taufik.kotlinhero.activity.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.taufik.kotlinhero.activity.profile.ProfileActivity
import com.taufik.kotlinhero.adapter.about.AboutKotlinAdapter
import com.taufik.kotlinhero.adapter.category.CategoryAdapter
import com.taufik.kotlinhero.data.MainData
import com.taufik.kotlinhero.databinding.ActivityMainBinding
import com.taufik.kotlinhero.model.aboutkotlin.AboutKotlinItem
import com.taufik.kotlinhero.model.category.CategoryItem

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var aboutKotlinAdapter: AboutKotlinAdapter
    private lateinit var categoryAdapter: CategoryAdapter
    private var aboutKotlinItemData = ArrayList<AboutKotlinItem>()
    private var categoryData = ArrayList<CategoryItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setRecyclerViewLayout()

        setProfileOnClick()
    }

    private fun setRecyclerViewLayout() {

        setRecyclerViewAboutKotlin()

        setRecyclerViewCategory()
    }

    private fun setRecyclerViewAboutKotlin() {

        aboutKotlinItemData = MainData.aboutKotlinData as ArrayList<AboutKotlinItem>
        aboutKotlinAdapter = AboutKotlinAdapter()

        binding.apply {
            rvAboutKotlin.layoutManager = GridLayoutManager(this@MainActivity, 3)
            rvAboutKotlin.setHasFixedSize(true)
            aboutKotlinAdapter.setDataAboutKotlin(aboutKotlinItemData)
            rvAboutKotlin.adapter = aboutKotlinAdapter
        }
    }

    private fun setRecyclerViewCategory() {

        categoryData = MainData.categoryTutorialData as ArrayList<CategoryItem>
        categoryAdapter = CategoryAdapter()

        binding.apply {
            rvCategory.layoutManager = GridLayoutManager(this@MainActivity, 2)
            rvCategory.setHasFixedSize(true)
            categoryAdapter.setDataCategoryList(categoryData)
            rvCategory.adapter = categoryAdapter
        }
    }

    private fun setProfileOnClick() {
        binding.apply {
            imgProfile.setOnClickListener{
                val intent = Intent(this@MainActivity, ProfileActivity::class.java)
                startActivity(intent)
            }
        }
    }
}