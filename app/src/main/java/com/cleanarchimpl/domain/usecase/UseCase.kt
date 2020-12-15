package com.cleanarchimpl.domain.usecase

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class UseCase {
    protected var disposable:Disposable?=null
    protected val compositeDisposable = CompositeDisposable()

    fun disposeLast(){
        disposable.let {
                    it?.dispose()
        }
    }

    fun dispose(){
        compositeDisposable.clear()
    }
}