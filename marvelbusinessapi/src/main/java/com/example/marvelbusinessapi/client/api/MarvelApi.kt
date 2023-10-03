package com.example.marvelbusinessapi.client.api


import com.example.marvelbusinessapi.client.model.CharactersMainResponse
import retrofit2.http.GET

interface MarvelApi {

    @GET("/v1/public/characters")
    fun getCharacters(): rx.Observable<CharactersMainResponse>
}
