package com.cleanarchitectureexample.viewmodel

import androidx.lifecycle.ViewModel
import com.cleanarchitectureexample.domain.UseCase

abstract class BaseViewModel (var usecase: UseCase):ViewModel(){


    protected var useCaseList: MutableList<UseCase> = mutableListOf()

    init {
        useCaseList.addAll(listOf(usecase))
    }

    override fun onCleared() {
        super.onCleared()
        useCaseList.forEach { it.dispose() }
    }
}