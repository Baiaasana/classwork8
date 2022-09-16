package com.example.classwork8.domain.use_case.base

interface BaseUseCaseWithoutParams< R > {

    suspend fun invoke() : R

}