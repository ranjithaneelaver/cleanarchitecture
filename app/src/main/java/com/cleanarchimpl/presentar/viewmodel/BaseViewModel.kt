package com.cleanarchimpl.presentar.viewmodel

import androidx.lifecycle.ViewModel
import com.cleanarchimpl.domain.usecase.UseCase

abstract class BaseViewModel ( usecase: UseCase):ViewModel(){
    private var useCaseList: MutableList<UseCase> = mutableListOf()
    init {
        useCaseList.addAll(listOf(usecase))
    }

    override fun onCleared() {
        super.onCleared()
        useCaseList.forEach { it.dispose() }
    }
}