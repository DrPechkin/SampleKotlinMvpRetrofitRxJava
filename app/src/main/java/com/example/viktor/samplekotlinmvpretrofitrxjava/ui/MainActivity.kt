package com.example.viktor.samplekotlinmvpretrofitrxjava.ui

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.example.viktor.samplekotlinmvpretrofitrxjava.R
import com.example.viktor.samplekotlinmvpretrofitrxjava.data.model.Android
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), MainContract.View {

    @JvmField
    @Inject
    var mainPresenter: MainPresenter? = null

    private var adapter = DataAdapter(ArrayList(0))
    private val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView(findViewById(R.id.rv_android_list))
    }

    private fun initRecyclerView(recyclerView: RecyclerView) {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        mainPresenter?.attachView(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        mainPresenter?.detachView(this)
    }

    override fun showData(data: List<Android>) {
        adapter.updateData(data)
    }

    override fun showNoData() {
        Toast.makeText(this, "No data =( ", Toast.LENGTH_SHORT).show()
    }

    override fun showLoadingDataError() {
        Toast.makeText(this, "Error loading data =( ", Toast.LENGTH_SHORT).show()
    }
}
