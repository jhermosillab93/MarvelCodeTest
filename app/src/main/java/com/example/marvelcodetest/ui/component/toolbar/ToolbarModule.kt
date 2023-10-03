package com.example.marvelcodetest.ui.component.toolbar

import androidx.lifecycle.ViewModel
import com.example.marvelcodetest.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ToolbarModule {

    @Binds
    @IntoMap
    @ViewModelKey(ToolbarViewModel::class)
    abstract fun bindToolbarViewModel(viewModel: ToolbarViewModel): ViewModel

}