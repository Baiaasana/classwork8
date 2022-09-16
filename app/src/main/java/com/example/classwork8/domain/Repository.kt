package com.example.classwork8.domain

import com.example.classwork8.StoreModel
import com.example.classwork8.utility.Resource
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun doNetworkCall(): Flow<Resource<StoreModel>>
}