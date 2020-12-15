package com.cleanarchimpl.domain.di

import com.cleanarchimpl.domain.usecase.MovieListUseCase
import org.koin.dsl.module

val createDomainModule = module {
    factory { MovieListUseCase(movieRepository = get()) }
}