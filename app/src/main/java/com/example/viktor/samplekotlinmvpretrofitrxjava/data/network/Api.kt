package com.example.viktor.samplekotlinmvpretrofitrxjava.data.network

import com.example.viktor.samplekotlinmvpretrofitrxjava.data.model.Android
import io.reactivex.Observable
import retrofit2.http.GET

interface Api {
    @GET("api/android")
    fun getData(): Observable<List<Android>>
}