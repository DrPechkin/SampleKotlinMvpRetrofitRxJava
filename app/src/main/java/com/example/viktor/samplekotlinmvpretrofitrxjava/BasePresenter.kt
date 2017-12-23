package com.example.viktor.samplekotlinmvpretrofitrxjava

interface BasePresenter<in V : BaseView> {
    fun attachView(view: V)

    fun detachView(view: V)
}