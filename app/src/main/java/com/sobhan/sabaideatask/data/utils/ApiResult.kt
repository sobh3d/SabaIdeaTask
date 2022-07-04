package com.sobhan.sabaideatask.data.utils

sealed class ApiResult<out T> {
    data class Success<T>(val data: T?) : ApiResult<T>()
    data class Error(
        val error: com.sobhan.sabaideatask.model.Error
    ) : ApiResult<Nothing>()

    companion object {
        const val FAILED_ERROR_CODE = 600
    }
}