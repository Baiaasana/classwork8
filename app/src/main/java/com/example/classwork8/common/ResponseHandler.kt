package com.example.classwork8.common

import android.util.Log.d
import com.example.classwork8.utility.Resource
import retrofit2.Response

class ResponseHandler {

    suspend fun <T> safeApiCall(request: suspend () -> Response<T>): Resource<T> =

        try {
            Resource.loading(null)
            val response = request.invoke()
            if (response.isSuccessful) {
                val result = response.body()!!
                d("log", " resp.handler -> $result")
                Resource.success(result)
            } else {
                Resource.error(response.message())
            }
        } catch (e: Exception) {
            Resource.error(e.message.toString())
        }
}