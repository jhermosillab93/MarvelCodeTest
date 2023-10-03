package com.example.marvelcodetest.ui.main

import androidx.lifecycle.ViewModel
import com.example.marvelcodetest.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class CharactersMainModule {

    @Binds
    @IntoMap
    @ViewModelKey(CharactersMainViewModel::class)
    abstract fun bindCharactersMainViewModel(viewModel: CharactersMainViewModel): ViewModel
}