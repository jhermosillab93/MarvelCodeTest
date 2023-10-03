package com.example.marvelcodetest.ui.characters.characterDetail

import androidx.lifecycle.ViewModel
import com.example.marvelcodetest.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class CharacterDetailsModule {

    @Binds
    @IntoMap
    @ViewModelKey(CharacterDetailsViewModel::class)
    abstract fun bindCharacterDetailsViewModel(viewModel: CharacterDetailsViewModel): ViewModel
}