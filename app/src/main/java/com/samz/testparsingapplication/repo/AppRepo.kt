package com.samz.testparsingapplication.repo

import javax.inject.Inject

class AppRepo @Inject constructor(private val apiInterface: ApiInterface) : RepoInterface,
    SafeApiCall() {

    override suspend fun getUsers(page: Int) =
        invokeRequest { apiInterface.getUsers(page) }
}