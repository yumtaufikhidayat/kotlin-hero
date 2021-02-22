package com.taufik.kotlinhero.data

import com.taufik.kotlinhero.model.category.CategoryItem

class MainCategory {
    companion object {
        val category: List<Any>
            get() = mutableListOf(
                "Tingkat Pemula",
                CategoryItem("Kotlin Basic"),
                CategoryItem("Kotlin Object Oriented Programming\n(OOP)"),

                "Tingkat Menengah",
                CategoryItem("Kotlin Generic"),
                CategoryItem("Kotlin Collection"),

                "Tingkat Lanjut",
                CategoryItem("Kotlin Coroutine"),
                CategoryItem("Kotlin Unit Testing"),
            )
    }
}