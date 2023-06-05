package com.taufik.kotlinhero.data.repository

import com.taufik.kotlinhero.data.source.RemoteDataSource
import javax.inject.Inject

class KotlinHeroRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) {
    fun getAllListCourses() = remoteDataSource.getAllListCourses()
}