package com.cleanarchimpl.domain.usecase

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

abstract class SingleUseCase<T, in Params> : UseCase() {

    internal abstract fun callAPI(params: Params): Single<T>
    fun execute(
        onSuccess: ((t: T) -> Unit),
        onError: ((t: Throwable) -> Unit),
        params: Params
    ) {
        disposeLast()
        disposable = callAPI(params)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(onSuccess, onError)
        disposable?.let { compositeDisposable.add(it) }
    }
}