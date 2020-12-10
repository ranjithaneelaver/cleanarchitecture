package com.cleanarchitectureexample.di.module

import com.cleanarchitectureexample.domain.MovieListUseCase
import org.koin.dsl.module

val createDomainModule = module {

    factory { MovieListUseCase(movieRepository = get()) }


}