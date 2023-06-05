package com.taufik.kotlinhero.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.taufik.kotlinhero.data.NetworkResult
import com.taufik.kotlinhero.data.remote.ApiService
import com.taufik.kotlinhero.model.response.ListCoursesItem
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService){

    fun getAllListCourses(): LiveData<NetworkResult<ArrayList<ListCoursesItem>>> = liveData {
        emit(NetworkResult.Loading)
        try {
            val response = apiService.getAllListCourses()
            emit(NetworkResult.Success(response))
        } catch (e: Exception) {
            emit(NetworkResult.Error(e.message.toString()))
        }
    }
}