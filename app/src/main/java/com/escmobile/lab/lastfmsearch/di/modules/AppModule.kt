package com.escmobile.lab.lastfmsearch.di.modules

import com.escmobile.lab.lastfmsearch.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class AppModule {

    @ContributesAndroidInjector
    internal abstract fun contributeMainActivityInjector(): MainActivity

}
