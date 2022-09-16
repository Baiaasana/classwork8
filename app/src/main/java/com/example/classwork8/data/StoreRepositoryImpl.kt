package com.example.classwork8.data

import com.example.classwork8.common.ResponseHandler
import com.example.classwork8.domain.repository.Repository
import com.example.classwork8.utility.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class StoreRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val responseHandler: ResponseHandler,
) : Repository {

    override suspend fun doNetworkCall(): Flow<Resource<List<StoreModel>>> = flow {
        emit(Resource.loading())
        emit(responseHandler.safeApiCall { api.getInfo() })
    }
}