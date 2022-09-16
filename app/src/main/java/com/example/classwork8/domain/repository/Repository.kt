package com.example.classwork8.domain.repository

import com.example.classwork8.data.StoreModel
import com.example.classwork8.utility.Resource
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun doNetworkCall(): Flow<Resource<List<StoreModel>>>
}