package com.samz.testparsingapplication.repo

import com.samz.testparsingapplication.model.UsersResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("users")
    suspend fun getUsers(@Query("page") page: Int): Response<UsersResponse>
}