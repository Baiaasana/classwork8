package com.example.classwork8.domain.use_case

import android.util.Log
import com.example.classwork8.data.StoreModel
import com.example.classwork8.domain.repository.Repository
import com.example.classwork8.utility.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetInfoUseCaseImpl @Inject constructor(
    private val repository: Repository,
) : GetInfoUseCase {

    override suspend fun invoke(): Flow<Resource<List<StoreModel>>> {
        Log.d("log", " use case  -> ${repository.doNetworkCall()}")
        return repository.doNetworkCall()
    }
}

