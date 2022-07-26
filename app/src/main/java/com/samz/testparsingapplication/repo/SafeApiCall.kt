package com.samz.testparsingapplication.repo

import android.util.Log
import com.samz.convertcurrency.utils.ApiException
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response

/**
 * Generic Class for customizing the API error response
 */
@Suppress("BlockingMethodInNonBlockingContext")
open class SafeApiCall {
    suspend fun <T> invokeRequest(call: suspend () -> Response<T>): T? {
        val response: Response<T> = call.invoke()
        if (response.isSuccessful) {
            return response.body()
        } else {
            val error = response.errorBody()?.string()
            val message = StringBuilder()
            error?.let {
                try {
                    message.append(JSONObject(it).getString("message"))
                    message.append("\n")
                } catch (e: JSONException) {
                    Log.i("JSONException", "Exception: $e")
                }

            }
            throw ApiException(response.code(), message.toString())
        }
    }

}