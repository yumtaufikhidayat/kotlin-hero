package com.taufik.kotlinhero.data

import com.taufik.kotlinhero.R
import com.taufik.kotlinhero.model.aboutkotlin.AboutKotlinItem
import com.taufik.kotlinhero.model.category.CategoryItem

class MainData {
    companion object{

        // About Kotlin (Three Menus)
        val aboutKotlinData: List<AboutKotlinItem>
            get() = mutableListOf(
                AboutKotlinItem(R.drawable.ic_docs, "Dokumentasi Kotlin"),
                AboutKotlinItem(R.drawable.ic_convention, "Coding Convention"),
                AboutKotlinItem(R.drawable.ic_contribute, "Kontribusi ke Kotlin")
            )

        // Main Category
        val categoryTutorialData: List<CategoryItem>
            get() = mutableListOf(
                CategoryItem(R.drawable.kotlin_logos,"Kotlin Dasar", "42 Video Tutorial"),
                CategoryItem(R.drawable.kotlin_logos,"Kotlin OOP", "51 Video Tutorial"),
                CategoryItem(R.drawable.kotlin_logos,"Kotlin Generic", "16 Video Tutorial"),
                CategoryItem(R.drawable.kotlin_logos,"Kotlin Collection", "42 Video Tutorial"),
                CategoryItem(R.drawable.kotlin_logos,"Kotlin Coroutine", "1 Video Tutorial"),
                CategoryItem(R.drawable.kotlin_logos,"Kotlin Unit Testing", "25 Video Tutorial")
            )
    }
}