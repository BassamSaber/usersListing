package com.samz.testparsingapplication.ui.base

import androidx.annotation.IdRes

interface ViewHolderInterface {
    fun onViewClicked(position: Int, @IdRes id: Int)
}