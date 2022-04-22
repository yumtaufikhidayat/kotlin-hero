package com.taufik.kotlinhero.data

import com.taufik.kotlinhero.R
import com.taufik.kotlinhero.data.source.local.About
import com.taufik.kotlinhero.model.aboutkotlin.AboutKotlinItem
import com.taufik.kotlinhero.model.category.CategoryItem

object MainData {
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
            CategoryItem(R.drawable.kotlin_logos,"Tutorial Kotlin Dasar", "42 Materi"),
            CategoryItem(R.drawable.kotlin_logos,"Tutorial Kotlin OOP", "51 Materi"),
            CategoryItem(R.drawable.kotlin_logos,"Tutorial Kotlin Generic", "16 Materi"),
            CategoryItem(R.drawable.kotlin_logos,"Tutorial Kotlin Collection", "42 Materi"),
            CategoryItem(R.drawable.kotlin_logos,"Tutorial Kotlin Coroutine", "1 Materi"),
            CategoryItem(R.drawable.kotlin_logos,"Tutorial Kotlin Unit Testing", "25 Materi")
        )

    fun generateAboutAuthorData(): List<About> {
        return mutableListOf(
            About(
                R.drawable.ic_outline_profile,
                "Let's greet",
                "Taufik Hidayat"
            ),

            About(
                R.drawable.github,
                "Fork on Github",
                "Fork this app on Github"
            ),

            About(
                R.drawable.ic_outline_email,
                "Send an email",
                "yumtaufikhidayat@gmail.com"
            ),

            About(
                R.drawable.ic_outline_bug,
                "Report an issue",
                "Found an issue? Report in here"
            )
        )
    }
}