package com.example.classwork8.data.remote

import android.content.Context
import android.content.Intent
import com.example.classwork8.utility.isConnected
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.Request

object Interceptors {

     fun onlineInterceptor() = Interceptor {
        val response = it.proceed(it.request())
        val maxAge = 60
        response.newBuilder()
            .header("Cache-Control", "public, max-age=" + maxAge)
            .removeHeader("Pragma")
            .build()
    }

     fun OflineInterseptor(context: Context) = Interceptor {
        var request = it.request()
        if(!context.isConnected) {
            val maxStale = 60*60*24*30
            request = request.newBuilder()
                .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                .removeHeader("Pragma")
                .build()
        }
        return@Interceptor it.proceed(request)
    }

     fun cacheSize(context: Context) : Cache{
        val cacheSize = (10 * 1024 * 1024).toLong() // 10 MB
        val cache = Cache(context.cacheDir, cacheSize)
         return cache
    }


}