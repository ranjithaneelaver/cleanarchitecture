package com.cleanarchitectureexample.Common

import android.app.Application
import com.cleanarchitectureexample.di.module.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@Application)
            modules(listOf(appModule,
                createDomainModule,
                viewModelModule, createRepositoryModule
            ))
        }
    }


}