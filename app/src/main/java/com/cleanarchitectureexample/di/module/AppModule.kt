package com.cleanarchitectureexample.di.module

import com.data.network.RetrofitClient
import org.koin.dsl.module


val appModule = module {
    single { RetrofitClient() }
}
