package com.cleanarchitectureexample.di.module

import com.domain.repository.MovieRepository
import com.data.repository.HomeRepositoryImpl
import org.koin.dsl.module

val createRepositoryModule = module {
    factory<MovieRepository> {
        HomeRepositoryImpl(
            restClient = get()
        )
    }
}