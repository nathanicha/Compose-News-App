package com.example.newsapp.domain.model

sealed class ApiResult<out T> {
    data class Success<out T>(val data: T) : ApiResult<T>()
    data class Error(val message: String, val code: String?) : ApiResult<Nothing>()
    object Loading : ApiResult<Nothing>()
}