package com.samz.convertcurrency.model.generalResponse

import androidx.annotation.NonNull
import androidx.annotation.Nullable

/**
 * General Response Object with the response status (Success/Error) and the API Response data
 * or the Error Response if the API Failed
 */
class Resources<T> {

    var status: DataStatus? = null

    @Nullable
    var data: T? = null

    @Nullable
    var error: Throwable? = null


    fun success(data: T): Resources<T> {
        this.status = DataStatus.SUCCESS
        this.data = data
        error = null
        return this
    }

    fun error(error: Throwable): Resources<T> {
        this.status = DataStatus.ERROR

        data = null
        this.error = error
        return this
    }

    enum class DataStatus {
        SUCCESS,
        ERROR,
    }
}

