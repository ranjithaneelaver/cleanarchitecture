package com.cleanarchimpl.presentar.viewmodel

import com.cleanarchimpl.domain.interfacelist.Emitter
import com.cleanarchimpl.domain.module.MovieData
import com.cleanarchimpl.domain.usecase.MovieListUseCase

class HomeViewModel(private val movieListUseCase: MovieListUseCase) :
    BaseViewModel(movieListUseCase) {

    init {
        println("init function")
    }
    fun requestPageData(
        url: String,
        apikey: String,
        mve: String,
        type: String,
        result: Emitter<MovieData>
    ) {
        movieListUseCase.execute(
            onSuccess = {
                result.onNext(it)
            },
            onError = { },
            params = MovieListUseCase.Params(url, apikey, mve, type)
        )
    }
}