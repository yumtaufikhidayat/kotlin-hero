package com.taufik.kotlinhero.model.response


import com.google.gson.annotations.SerializedName

data class ListCoursesItem(
    @SerializedName("courses")
    val courses: String = "", // 42
    @SerializedName("id")
    val id: Int = 0, // 1
    @SerializedName("name")
    val name: String = "" // Tutorial Kotlin Dasar
)