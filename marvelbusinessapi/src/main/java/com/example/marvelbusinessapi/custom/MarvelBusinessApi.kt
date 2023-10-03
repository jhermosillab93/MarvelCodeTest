package com.example.marvelbusinessapi.custom

import com.example.marvelbusinessapi.base.RequestApi
import com.example.marvelbusinessapi.client.model.CharactersMainResponse
import com.example.marvelbusinessapi.custom.request.CharactersListRequest

interface MarvelBusinessApi {
    fun getCharactersList(): RequestApi<CharactersListRequest.MyParameters, CharactersMainResponse>
}