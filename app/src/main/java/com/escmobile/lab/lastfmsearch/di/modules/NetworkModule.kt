package com.escmobile.lab.lastfmsearch.di.modules

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {

        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val original = chain.request()
                val builder = original.newBuilder().method(original.method(), original.body())
                builder.header("Content-Type", "application/x-www-form-urlencoded")
                chain.proceed(builder.build())
            }.build()
    }

}