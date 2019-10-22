package com.escmobile.lab.lastfmsearch.di.modules

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import com.escmobile.lab.lastfmsearch.LastFMSearchApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

const val PREF_FILE = "lastfmsearch.prefs"

@Module
class UtilsModule(
    private val context: Context,
    private val application: Application
) {

    @Provides
    fun providesApplication(): Application {
        return application
    }

    @Provides
    fun providesLastFMSearchApplication(): LastFMSearchApp {
        return application as LastFMSearchApp
    }

    @Provides
    fun providesContext(): Context {
        return context
    }

    @Provides
    fun providesResources(): Resources {
        return context.resources
    }

    @Singleton
    @Provides
    fun providesSharedPref(): SharedPreferences {
        return context.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE)
    }
}