package com.example.classwork8.utility

import com.example.classwork8.data.StoreModel

data class InfoViewState(
    val isLoading: Boolean? = null,
    val data: List<StoreModel>? = emptyList(),
    val errorMessage: String? = null,
)