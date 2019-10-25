package com.escmobile.lab.lastfmsearch.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.escmobile.lab.lastfmsearch.utils.ViewModelFactory
import com.escmobile.lab.lastfmsearch.utils.ViewModelKey
import com.escmobile.lab.lastfmsearch.viewmodels.SearchViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    internal abstract fun searchViewModel(viewModel: SearchViewModel): ViewModel

}