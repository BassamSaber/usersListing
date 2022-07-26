package com.samz.testparsingapplication.ui.base

import androidx.annotation.LayoutRes

interface BaseItemViewModel {
    @LayoutRes
    fun getLayoutId(): Int
}