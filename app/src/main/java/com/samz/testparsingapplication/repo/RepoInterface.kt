package com.samz.testparsingapplication.repo

import com.samz.testparsingapplication.model.UsersResponse

interface RepoInterface {

    suspend fun getUsers(page: Int): UsersResponse?
}