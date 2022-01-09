package com.taufik.kotlinhero.model.category

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CategoryItem(
    val categoryIcon: Int,
    val categoryName: String,
    val categoryNumber: String
): Parcelable
