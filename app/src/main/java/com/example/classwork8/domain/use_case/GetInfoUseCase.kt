package com.example.classwork8.domain.use_case

import com.example.classwork8.data.StoreModel
import com.example.classwork8.domain.use_case.base.BaseUseCaseWithoutParams
import com.example.classwork8.utility.Resource
import kotlinx.coroutines.flow.Flow

interface GetInfoUseCase : BaseUseCaseWithoutParams<Flow<Resource<List<StoreModel>>>> {
    override suspend fun invoke(): Flow<Resource<List<StoreModel>>>
}
