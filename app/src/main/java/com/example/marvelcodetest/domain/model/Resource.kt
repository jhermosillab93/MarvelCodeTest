package com.example.marvelcodetest.domain.model

sealed class Resource<T> {

    data class Loading<T>(val data: T? = null) : Resource<T>()

    data class Success<T>(val data: T) : Resource<T>()

    data class Error<T>(val throwable: Throwable, val lastData: T? = null) : Resource<T>()

}

sealed class ResourceStatus<T, U: Throwable> {

    data class Loading<T, U: Throwable>(val data: T? = null) : ResourceStatus<T, U>()

    data class Success<T, U: Throwable>(val data: T) : ResourceStatus<T, U>()

    data class Error<T, U: Throwable>(val error: U, val lastData: T? = null) : ResourceStatus<T, U>()

}