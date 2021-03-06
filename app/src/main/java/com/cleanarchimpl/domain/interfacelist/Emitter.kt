package com.cleanarchimpl.domain.interfacelist

interface Emitter<T> {
    fun onNext(value: T)
    fun onError(error: Throwable?)
    fun onComplete()
}