package com.taufik.kotlinhero.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import com.taufik.kotlinhero.data.MainData
import com.taufik.kotlinhero.data.repository.KotlinHeroRepository
import com.taufik.kotlinhero.model.aboutkotlin.AboutKotlinItem
import com.taufik.kotlinhero.model.category.CategoryItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: KotlinHeroRepository
) : ViewModel() {
    fun showReferenceData(): List<AboutKotlinItem> = MainData.aboutKotlinData
    fun showCourseCategory(): List<CategoryItem> = MainData.courseCategoryData

    fun getAllListCourses() = repository.getAllListCourses()
}