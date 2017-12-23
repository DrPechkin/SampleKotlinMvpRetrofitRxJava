package com.example.viktor.samplekotlinmvpretrofitrxjava.ui

import com.example.viktor.samplekotlinmvpretrofitrxjava.data.DataRepository
import com.example.viktor.samplekotlinmvpretrofitrxjava.data.model.Android
import com.example.viktor.samplekotlinmvpretrofitrxjava.ui.MainContract.View
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainPresenter @Inject constructor(val repository: DataRepository) : MainContract.Presenter {

    @JvmField
    @Inject
    var mainView: MainContract.View? = null

    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun loadData() {
        compositeDisposable.clear()
        val disposable: Disposable = repository
                .getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ data -> processData(data)
                    }, { _ -> mainView?.showLoadingDataError()}
                )
        compositeDisposable.add(disposable)
    }

    private fun processData(data: List<Android>) {
        if (data.isEmpty()) {
            mainView?.showNoData()
        } else {
            mainView?.showData(data)
        }
    }

    override fun attachView(view: View) {
        this.mainView = view
        loadData()
    }

    override fun detachView(view: View) {
        this.mainView = null
        compositeDisposable.clear()
    }
}