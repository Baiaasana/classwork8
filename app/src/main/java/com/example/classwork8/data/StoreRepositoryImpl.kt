package com.example.classwork8.data

import android.util.Log.d
import com.example.classwork8.StoreModel
import com.example.classwork8.common.Inflater
import com.example.classwork8.domain.Repository
import com.example.classwork8.utility.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class StoreRepositoryImpl @Inject constructor(
    private val api:ApiService
) : Repository {
    override suspend fun doNetworkCall(): Flow<Resource<StoreModel>> = flow {
        try {
            emit(Resource.loading(null))
            val response = api.getInfo()
            if (response.isSuccessful) {
                val result = response.body()!!
                d("log", "$result")
                emit(Resource.success(result))
            } else {
                emit(Resource.error(response.message()))
            }
        } catch (e: Exception) {
            emit(Resource.error(e.message.toString()))
        }
    }

}