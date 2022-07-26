package com.samz.testparsingapplication.ui.ui.main

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samz.convertcurrency.model.generalResponse.Resources
import com.samz.convertcurrency.model.generalResponse.Resources.DataStatus.ERROR
import com.samz.convertcurrency.model.generalResponse.Resources.DataStatus.SUCCESS
import com.samz.convertcurrency.utils.ApiException
import com.samz.testparsingapplication.R
import com.samz.testparsingapplication.repo.AppRepo
import com.samz.testparsingapplication.ui.base.BaseAdapter
import com.samz.testparsingapplication.utils.ResourcesUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appRepo: AppRepo,
    private val resUtils: ResourcesUtils
) : ViewModel() {
    private fun <T> call(work: suspend () -> T, callback: (Resources<T>) -> Unit) {
        val data: Resources<T> = Resources()
        viewModelScope.launch {
            try {
                val response = work.invoke()
                data.success(response)
            } catch (error: ApiException) {
                data.error(error)
            } catch (error: Exception) {
                data.error(error)
            }
            callback(data)
        }
    }


    private val list = arrayListOf<UserItemViewModel>()
    val adapter = BaseAdapter<UserItemViewModel>(list)

    val isLoading = ObservableBoolean(false)
    val errorMsg = ObservableField("")

    fun getUsers() {
        isLoading.set(true)
        call({ appRepo.getUsers(1) }, { response ->
            isLoading.set(false)
            when (response.status!!) {
                SUCCESS -> {
                    list.clear()
                    if (response.data?.users?.isNotEmpty() == true)
                        for (item in response.data!!.users)
                            list.add(UserItemViewModel(item))
                    adapter.notifyDataSetChanged()
                }
                ERROR -> errorMsg.set(
                    response.error?.message ?: resUtils.getString(R.string.something_went_wrong)
                )
            }
        })
    }
}