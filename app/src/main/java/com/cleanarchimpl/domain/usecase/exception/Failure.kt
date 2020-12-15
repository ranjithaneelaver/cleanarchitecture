package com.cleanarchimpl.domain.usecase.exception

sealed class Failure {
    data class ApiError(val httpCode: Int, val errorMsg: String) : Failure()
    data class UnCatchError(val exception: Exception) : Failure()
}