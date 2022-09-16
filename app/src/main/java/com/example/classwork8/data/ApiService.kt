package com.example.classwork8.data

import com.example.classwork8.utility.Const
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Const.END_POINT)
    suspend fun getInfo() : Response<List<StoreModel>>

}