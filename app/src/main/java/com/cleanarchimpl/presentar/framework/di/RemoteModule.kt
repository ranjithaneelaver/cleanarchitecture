package com.cleanarchimpl.presentar.framework.di

import com.cleanarchimpl.presentar.framework.APIInterface
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.cleanarchimpl.presentar.framework.exception_interceptor.RemoteExceptionInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val createRemoteModule = module {
    factory<Interceptor> {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.HEADERS
        }
    }

    factory {
        OkHttpClient.Builder()
            .addInterceptor(get())
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl("https://www.omdbapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }
    factory { get<Retrofit>().create(APIInterface::class.java) }
    single { RemoteExceptionInterceptor() }
}

