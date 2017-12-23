package com.example.viktor.samplekotlinmvpretrofitrxjava.ui

import com.example.viktor.samplekotlinmvpretrofitrxjava.BasePresenter
import com.example.viktor.samplekotlinmvpretrofitrxjava.BaseView
import com.example.viktor.samplekotlinmvpretrofitrxjava.data.model.Android

interface MainContract {
    interface View : BaseView {
        fun showData(data: List<Android>)
        fun showNoData()
        fun showLoadingDataError()
    }

    interface Presenter : BasePresenter<View> {
        fun loadData()
    }
}