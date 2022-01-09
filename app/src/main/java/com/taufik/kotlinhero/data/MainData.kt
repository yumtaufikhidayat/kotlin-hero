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
                CategoryItem(R.drawable.kotlin_logos,"Tutorial\nKotlin Dasar", "42 Materi"),
                CategoryItem(R.drawable.kotlin_logos,"Tutorial\nKotlin OOP", "51 Materi"),
                CategoryItem(R.drawable.kotlin_logos,"Tutorial\nKotlin Generic", "16 Materi"),
                CategoryItem(R.drawable.kotlin_logos,"Tutorial\nKotlin Collection", "42 Materi"),
                CategoryItem(R.drawable.kotlin_logos,"Tutorial\nKotlin Coroutine", "1 Materi"),
                CategoryItem(R.drawable.kotlin_logos,"Tutorial\nKotlin Unit Testing", "25 Materi")
            )
    }
}