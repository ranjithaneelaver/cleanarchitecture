package com.cleanarchimpl.domain.usecase.exception

interface ExceptionInterceptor {
    fun handleException(exception: Exception): Failure?
}