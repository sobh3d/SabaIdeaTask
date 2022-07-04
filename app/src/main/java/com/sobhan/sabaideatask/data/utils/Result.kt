package com.sobhan.sabaideatask.data.utils

sealed class Result<out T> {
    object Loading : Result<Nothing>()
    object Empty : Result<Nothing>()
    data class Success<T>(val data: T) : Result<T>()
    data class Error(val error: com.sobhan.sabaideatask.model.Error) : Result<Nothing>()


}