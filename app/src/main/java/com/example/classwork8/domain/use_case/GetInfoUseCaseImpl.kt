package com.example.classwork8.domain.use_case

import com.example.classwork8.StoreModel
import com.example.classwork8.domain.Repository
import com.example.classwork8.utility.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetInfoUseCaseImpl @Inject constructor(
    private val repository: Repository,
) : GetInfoUseCase {

    override suspend fun invoke(): Flow<Resource<StoreModel>> = repository.doNetworkCall()

}

