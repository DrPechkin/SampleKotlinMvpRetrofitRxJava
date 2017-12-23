package com.example.viktor.samplekotlinmvpretrofitrxjava.di.module

import com.example.viktor.samplekotlinmvpretrofitrxjava.data.network.Api
import dagger.Module
import retrofit2.Retrofit
import javax.inject.Singleton
import dagger.Provides
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ServiceModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://learn2crack-json.herokuapp.com")
                .build()
    }

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): Api {
        return retrofit.create<Api>(Api::class.java)
    }
}