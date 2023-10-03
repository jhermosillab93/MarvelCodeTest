package com.example.marvelcodetest.di

import androidx.lifecycle.ViewModelProvider
import com.example.marvelcodetest.ui.characters.characterDetail.CharacterDetailsFragment
import com.example.marvelcodetest.ui.characters.characterDetail.CharacterDetailsModule
import com.example.marvelcodetest.ui.component.toolbar.ToolbarModule
import com.example.marvelcodetest.ui.characters.characterslist.CharactersListFragment
import com.example.marvelcodetest.ui.characters.characterslist.CharactersListModule
import com.example.marvelcodetest.ui.main.CharactersMainActivity
import com.example.marvelcodetest.ui.main.CharactersMainModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Scope

@MustBeDocumented
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScoped

@Module
abstract class ViewModelModule: ToolbarModule() {

    /**
     * VIEW MODEL
     */
    @Binds
    internal abstract fun bindViewModelFactory(factory: IOSchedViewModelFactory): ViewModelProvider.Factory

    /**
     * ACTIVITY
     */

    @ActivityScoped
    @ContributesAndroidInjector(modules = [CharactersMainModule::class])
    internal abstract fun charactersMainActivity(): CharactersMainActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [CharactersListModule::class])
    internal abstract fun charactersListFragment(): CharactersListFragment

    @ActivityScoped
    @ContributesAndroidInjector(modules = [CharacterDetailsModule::class])
    internal abstract fun charactersDetailsFragment(): CharacterDetailsFragment

}