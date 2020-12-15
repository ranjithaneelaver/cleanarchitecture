package com.cleanarchimpl.presentar.di.module

import com.cleanarchimpl.presentar.viewmodel.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        HomeViewModel(get())
    }
}

