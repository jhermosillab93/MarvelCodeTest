package com.example.marvelcodetest.di

import android.content.Context
import com.example.marvelbusinessapi.custom.MarvelBusinessApi
import com.example.marvelcodetest.core.MainApplication
import com.example.marvelcodetest.domain.data.repository.MarvelDataRepository
import com.example.marvelcodetest.domain.data.source.local.UserLocalData
import com.example.marvelcodetest.domain.repository.MarvelRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Defines all the classes that need to be provided in the scope of the app.
 *
 * Define here all objects that are shared throughout the app, like SharedPreferences, navigators or
 * others. If some of those objects are singletons, they should be annotated with `@Singleton`.
 */
@Module
class AppModule {

    @Provides
    fun provideContext(application: MainApplication): Context = application.applicationContext

    @Provides
    @Singleton
    fun provideMarvelBusinessRepository(userLocalData: UserLocalData,marvelBusinessApi: MarvelBusinessApi):
            MarvelRepository = MarvelDataRepository(userLocalData, marvelBusinessApi)

}