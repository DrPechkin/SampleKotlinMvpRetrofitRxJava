package com.example.viktor.samplekotlinmvpretrofitrxjava.di.module

import com.example.viktor.samplekotlinmvpretrofitrxjava.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    internal abstract fun bindMainActivity(): MainActivity
}