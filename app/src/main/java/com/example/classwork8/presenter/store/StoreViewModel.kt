package com.example.classwork8.presenter.store

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.classwork8.data.StoreModel
import com.example.classwork8.domain.use_case.GetInfoUseCase
import com.example.classwork8.utility.InfoViewState
import com.example.classwork8.utility.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StoreViewModel @Inject constructor(
    val useCase: GetInfoUseCase,
) : ViewModel() {

    private val _infoState = MutableStateFlow<InfoViewState>(InfoViewState())
    val infoState = _infoState.asStateFlow()

    fun getInfo(){
//        resetState()
        viewModelScope.launch {
                useCase.invoke().collect {
                when (it.status) {
                    Resource.Status.SUCCESS -> {
                        val result = (it.data as List<StoreModel>)
                        _infoState.value = _infoState.value.copy(isLoading = false, data = it.data)
                        Log.d("log1", " success - $result")
                    }
                    Resource.Status.ERROR -> {
                        _infoState.value = _infoState.value.copy(isLoading = false,
                            errorMessage = it.message.toString())
                        Log.d("log1", "error")
                    }
                    Resource.Status.LOADING -> {
                        _infoState.value = _infoState.value.copy(isLoading = true)
                        Log.d("log1", "loading")
                    }
                }
            }
        }
    }
    private fun resetState() {
        _infoState.value = _infoState.value.copy(
            isLoading = null,
            data = null,
            errorMessage = null,
        )
    }
}

