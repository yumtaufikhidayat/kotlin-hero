package com.taufik.kotlinhero.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import com.taufik.kotlinhero.data.MainData
import com.taufik.kotlinhero.model.aboutkotlin.AboutKotlinItem
import com.taufik.kotlinhero.model.category.CategoryItem

class HomeViewModel : ViewModel() {
    fun showReferenceData(): List<AboutKotlinItem> = MainData.aboutKotlinData
    fun showCourseCategory(): List<CategoryItem> = MainData.courseCategoryData
}