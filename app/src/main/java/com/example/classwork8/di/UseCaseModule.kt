package com.example.classwork8.di

import com.example.classwork8.domain.use_case.GetInfoUseCase
import com.example.classwork8.domain.use_case.GetInfoUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    @Singleton
    abstract fun bindFactsUseCaseWithParams(
        getInfoUseCaseImpl: GetInfoUseCaseImpl,
    ): GetInfoUseCase

}