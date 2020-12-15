package com.cleanarchimpl.presentar.framework.exception_interceptor

import com.cleanarchimpl.domain.usecase.exception.ExceptionInterceptor
import com.cleanarchimpl.domain.usecase.exception.Failure
import retrofit2.HttpException

class RemoteExceptionInterceptor : ExceptionInterceptor {
    override fun handleException(exception: Exception): Failure? {
        return when (exception) {
            is HttpException -> {
                val errorMsg = if (exception.message() != null) {
                    exception.message()
                } else {
                    ""
                }
                Failure.ApiError(exception.code(), errorMsg)
            }
            else -> null
        }
    }
}