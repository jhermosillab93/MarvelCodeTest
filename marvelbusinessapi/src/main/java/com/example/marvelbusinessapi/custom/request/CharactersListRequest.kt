package com.example.marvelbusinessapi.custom.request

import com.example.marvelbusinessapi.client.api.MarvelApi
import com.example.marvelbusinessapi.base.ParametersApi
import com.example.marvelbusinessapi.base.RequestApi
import com.example.marvelbusinessapi.client.model.CharactersMainResponse
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

class CharactersListRequest @Inject constructor(private val marvelApi: MarvelApi)
    : RequestApi<CharactersListRequest.MyParameters, CharactersMainResponse> {

    data class MyParameters(val void: Void? = null): ParametersApi

    private var myParameters: MyParameters? = null

    override fun setParameters(parametersApi: MyParameters): RequestApi<MyParameters, CharactersMainResponse> {
        myParameters = parametersApi
        return this
    }

    override fun call(): Observable<CharactersMainResponse> {
        return marvelApi
            .getCharacters()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
    }

}