package com.example.viktor.samplekotlinmvpretrofitrxjava.di.module

import com.example.viktor.samplekotlinmvpretrofitrxjava.ui.MainActivity
import com.example.viktor.samplekotlinmvpretrofitrxjava.ui.MainContract
import com.example.viktor.samplekotlinmvpretrofitrxjava.ui.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun provideMainView(mainActivity: MainActivity): MainContract.View = mainActivity

    @Provides
    fun provideMainPresenter(presenter: MainPresenter): MainContract.Presenter = presenter
}