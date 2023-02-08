package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val list: List<City>) : RecyclerView.Adapter<MyAdapter.MyView>() {
    class MyView(item: View) : RecyclerView.ViewHolder(item) {
        val imgView = item.findViewById<ImageView>(R.id.imageView)
        val tvName = item.findViewById<TextView>(R.id.tvName)
        val tvCode = item.findViewById<TextView>(R.id.tvCode)
        val tvPop = item.findViewById<TextView>(R.id.tvPop)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        val myItem = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyView(myItem)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.imgView.setImageResource(R.drawable.baseline_location_city_24)
        holder.tvName.text = list[position].name
        holder.tvCode.text = list[position].code
        holder.tvPop.text = list[position].population.toString()
    }
}