package com.example.classwork8.di

import com.example.classwork8.data.StoreRepositoryImpl
import com.example.classwork8.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindRepository(
        storeRepositoryImpl: StoreRepositoryImpl
    ): Repository
}