package com.escmobile.lab.lastfmsearch.di.modules

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import com.escmobile.lab.lastfmsearch.LastFMSearchApp
import com.escmobile.lab.lastfmsearch.R
import com.escmobile.lab.lastfmsearch.managers.SearchManager
import com.escmobile.lab.lastfmsearch.managers.SearchManagerImpl
import com.escmobile.lab.lastfmsearch.services.SearchApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
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

    @Singleton
    @Provides
    fun provideSearchApiService(okHttpClient: OkHttpClient): SearchApiService {
        val retrofit = Retrofit
            .Builder()
            .baseUrl(context.getString(R.string.search_api_base_url))
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(SearchApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val httpBuilder = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val original = chain.request()
                val builder = original.newBuilder().method(original.method(), original.body())
                builder.header("Content-Type", "application/x-www-form-urlencoded")
                chain.proceed(builder.build())
            }

        return httpBuilder.build()
    }

    @Singleton
    @Provides
    fun provideSearchManager(searchApiService: SearchApiService): SearchManager {
        return SearchManagerImpl(searchApiService, context)
    }
}