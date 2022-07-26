package com.samz.testparsingapplication.model

import com.google.gson.annotations.SerializedName

data class UsersResponse(
    @SerializedName("data")
    val users: List<User>,
    @SerializedName("page")
    val page: Int,
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("total")
    val total: Int,
)