package com.example.viktor.samplekotlinmvpretrofitrxjava.di.component

import android.app.Application
import com.example.viktor.samplekotlinmvpretrofitrxjava.App
import com.example.viktor.samplekotlinmvpretrofitrxjava.data.DataRepository
import com.example.viktor.samplekotlinmvpretrofitrxjava.di.module.ActivityBuilderModule
import com.example.viktor.samplekotlinmvpretrofitrxjava.di.module.AppModule
import com.example.viktor.samplekotlinmvpretrofitrxjava.di.module.ServiceModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ActivityBuilderModule::class,
    ServiceModule::class
])
interface AppComponent : AndroidInjector<App> {

    fun provideRepository(): DataRepository

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun build(): AppComponent
    }
}