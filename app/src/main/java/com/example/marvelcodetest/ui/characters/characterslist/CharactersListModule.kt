package com.example.marvelcodetest.ui.characters.characterslist

import androidx.lifecycle.ViewModel
import com.example.marvelcodetest.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class CharactersListModule {

    @Binds
    @IntoMap
    @ViewModelKey(CharactersListViewModel::class)
    abstract fun bindCharactersListViewModel(viewModel: CharactersListViewModel): ViewModel
}