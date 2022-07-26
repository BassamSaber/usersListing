package com.samz.testparsingapplication.ui.ui.main

import androidx.databinding.ObservableField
import com.samz.testparsingapplication.R
import com.samz.testparsingapplication.model.User
import com.samz.testparsingapplication.ui.base.BaseItemViewModel

class UserItemViewModel constructor(private val user: User) : BaseItemViewModel {
    val imageUrl = ObservableField("")
    val name = ObservableField("")
    val email = ObservableField("")

    init {
        imageUrl.set(user.avatar)
        name.set("${user.firstName} ${user.lastName}")
        email.set(user.email)
    }

    override fun getLayoutId(): Int = R.layout.item_user
}