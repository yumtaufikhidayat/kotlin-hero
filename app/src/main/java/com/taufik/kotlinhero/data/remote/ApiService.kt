package com.taufik.kotlinhero.data.remote

import com.taufik.kotlinhero.model.response.ListCoursesItem
import retrofit2.http.GET

interface ApiService {

    @GET(UrlConstant.LIST_COURSES)
    suspend fun getAllListCourses(): ArrayList<ListCoursesItem>
}