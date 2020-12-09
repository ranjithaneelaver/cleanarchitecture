package com.cleanarchitectureexample.Common

import android.app.Application
import com.cleanarchitectureexample.di.module.appModule
import com.cleanarchitectureexample.di.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@Application)
            modules(listOf(appModule,
                viewModelModule
            ))
        }
    }


}