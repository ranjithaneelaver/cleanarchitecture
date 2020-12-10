package com.samplekotlinapplication.user.viewmodel

import com.cleanarchitectureexample.domain.MovieListUseCase
import com.cleanarchitectureexample.viewmodel.BaseViewModel
import com.domain.module.MovieData


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
        result: com.domain.interfacelist.Emitter<MovieData>
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