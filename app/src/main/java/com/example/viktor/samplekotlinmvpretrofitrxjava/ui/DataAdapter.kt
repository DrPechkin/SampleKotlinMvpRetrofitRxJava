package com.example.viktor.samplekotlinmvpretrofitrxjava.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viktor.samplekotlinmvpretrofitrxjava.R
import com.example.viktor.samplekotlinmvpretrofitrxjava.data.model.Android
import kotlinx.android.synthetic.main.item_recycler.view.tv_api_level
import kotlinx.android.synthetic.main.item_recycler.view.tv_name
import kotlinx.android.synthetic.main.item_recycler.view.tv_version
import android.graphics.Color

class DataAdapter(private val dataList: ArrayList<Android>
) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    private val colors: Array<String> = arrayOf("#EF5350", "#EC407A", "#AB47BC", "#7E57C2", "#5C6BC0", "#42A5F5")

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(dataList[position], colors, position)
    }

    override fun getItemCount(): Int = dataList.count()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)

        return ViewHolder(view)
    }

    fun updateData(dataList: List<Android>){
        this.dataList.clear()
        this.dataList.addAll(dataList)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(android: Android, colors: Array<String>, position: Int) {

            itemView.tv_name.text = android.name
            itemView.tv_version.text = android.version
            itemView.tv_api_level.text = android.apiLevel
            itemView.setBackgroundColor(Color.parseColor(colors[position % 6]))

            //itemView.setOnClickListener { }
        }
    }
}