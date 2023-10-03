package com.example.marvelcodetest.di

import com.example.marvelbusinessapi.custom.di.MarvelBusinessApiModule
import com.example.marvelcodetest.core.MainApplication
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Main component of the app, created and persisted in the Application class.
 *
 * Whenever a new module is created, it should be added to the list of modules.
 * [AndroidSupportInjectionModule] is the module from Dagger.Android that helps with the
 * generation and location of subcomponents.
 */
@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ViewModelModule::class,
        MarvelBusinessApiModule::class])

interface AppComponent: AndroidInjector<MainApplication> {

    @Component.Builder
    abstract class Builder: AndroidInjector.Builder<MainApplication>()

}