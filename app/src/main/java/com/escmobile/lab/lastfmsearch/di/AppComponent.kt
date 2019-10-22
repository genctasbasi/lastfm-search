package com.escmobile.lab.lastfmsearch.di

import com.escmobile.lab.lastfmsearch.LastFMSearchApp
import com.escmobile.lab.lastfmsearch.di.modules.AppModule
import com.escmobile.lab.lastfmsearch.di.modules.UtilsModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AndroidInjectionModule::class,
        AppModule::class,
        UtilsModule::class]
)

interface AppComponent : AndroidInjector<LastFMSearchApp> {

}