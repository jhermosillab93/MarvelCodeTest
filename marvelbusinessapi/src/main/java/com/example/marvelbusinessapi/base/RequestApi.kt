package com.example.marvelbusinessapi.base

import rx.Observable

interface RequestApi<P : ParametersApi?, T> {
    fun setParameters(parametersApi: P): RequestApi<P, T>
    fun call(): Observable<T>
}
