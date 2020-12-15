package com.cleanarchimpl.presentar.di.module

import com.cleanarchimpl.presentar.framework.RemoteDataSource
import com.cleanarchimpl.data.HomeRepositoryImpl
import com.cleanarchimpl.data.MovieDataSource
import com.cleanarchimpl.domain.repository.MovieRepository
import org.koin.dsl.module

val createRepositoryModule = module {
    factory {
        RemoteDataSource(apiInterface = get())
    }
    factory {
        MovieDataSource(remoteDataSource = get())
    }
    factory<MovieRepository> {
        HomeRepositoryImpl(
            movieDataSource = get()
        ) }
}