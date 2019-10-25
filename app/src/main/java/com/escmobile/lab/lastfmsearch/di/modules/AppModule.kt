package com.escmobile.lab.lastfmsearch.di.modules

import com.escmobile.lab.lastfmsearch.ui.DetailsFragment
import com.escmobile.lab.lastfmsearch.ui.MainActivity
import com.escmobile.lab.lastfmsearch.ui.SearchFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class AppModule {

    @ContributesAndroidInjector
    internal abstract fun contributeMainActivityInjector(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeSearchFragmentInjector(): SearchFragment

    @ContributesAndroidInjector
    abstract fun contributeDetailsFragmentInjector(): DetailsFragment

}
