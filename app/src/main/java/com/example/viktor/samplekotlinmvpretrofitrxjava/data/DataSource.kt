package com.example.viktor.samplekotlinmvpretrofitrxjava.data

import com.example.viktor.samplekotlinmvpretrofitrxjava.data.model.Android
import io.reactivex.Observable

interface DataSource {
    fun getData(): Observable<List<Android>>
}