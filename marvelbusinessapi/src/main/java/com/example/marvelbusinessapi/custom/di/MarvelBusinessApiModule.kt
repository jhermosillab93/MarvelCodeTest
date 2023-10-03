package com.example.marvelbusinessapi.custom.di

import com.example.marvelbusinessapi.BuildConfig
import com.example.marvelbusinessapi.custom.MarvelBusinessApi
import com.example.marvelbusinessapi.client.api.MarvelApi
import com.example.marvelbusinessapi.base.RequestApi
import com.example.marvelbusinessapi.client.ApiClient
import com.example.marvelbusinessapi.client.model.CharactersMainResponse
import com.example.marvelbusinessapi.custom.demo.MarvelApiDemo
import com.example.marvelbusinessapi.custom.request.CharactersListRequest
import dagger.Module
import dagger.Provides

@Module
class MarvelBusinessApiModule {

    @Provides
    fun provideApiClient(): ApiClient {
        return ApiClient()
    }

    @Provides
    fun provideMarvelApi(apiClient: ApiClient): MarvelApi {
        return if (!BuildConfig.IS_DEMO) {
            apiClient.createService(MarvelApi::class.java)
        } else MarvelApiDemo()
    }

    @Provides
    fun provideMarvelBusinessApi(marvelApi: MarvelApi): MarvelBusinessApi {
        return object : MarvelBusinessApi {
            override fun getCharactersList(): RequestApi<CharactersListRequest.MyParameters, CharactersMainResponse> {
                return CharactersListRequest(marvelApi)
            }
        }
    }
}