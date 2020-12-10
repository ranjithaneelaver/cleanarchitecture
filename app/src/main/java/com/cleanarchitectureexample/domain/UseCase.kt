package com.cleanarchitectureexample.domain


import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class UseCase {

    protected var disposable:Disposable?=null
    protected val compositeDisposable = CompositeDisposable()

    fun disposeLast(){
        disposable.let {
            if (it != null) {
                if(!it.isDisposed){
                    it?.dispose()
                }
            }
        }
    }

    fun dispose(){
        compositeDisposable.clear()
    }
}