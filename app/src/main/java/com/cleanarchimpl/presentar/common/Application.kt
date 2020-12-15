package com.cleanarchimpl.presentar.common

import android.app.Application
import com.cleanarchimpl.domain.di.createDomainModule
import com.cleanarchimpl.presentar.di.module.createRepositoryModule
import com.cleanarchimpl.presentar.di.module.viewModelModule
import com.cleanarchimpl.presentar.framework.di.createRemoteModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@Application)
            modules(listOf(
                createRemoteModule,
                createDomainModule,
                viewModelModule, createRepositoryModule
            ))
        }
    }


}