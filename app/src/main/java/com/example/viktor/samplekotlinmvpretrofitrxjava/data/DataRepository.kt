package com.example.viktor.samplekotlinmvpretrofitrxjava.data

import com.example.viktor.samplekotlinmvpretrofitrxjava.data.model.Android
import com.example.viktor.samplekotlinmvpretrofitrxjava.data.network.Api
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataRepository @Inject constructor() : DataSource {

    @Inject
    lateinit var api: Api

    override fun getData(): Observable<List<Android>> {
        return api.getData()
    }
}