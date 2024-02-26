package com.example.sharedpreference

import android.graphics.Color
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.graphics.red
import androidx.recyclerview.widget.RecyclerView
class Recyclerview(var activity:MainActivity): RecyclerView.Adapter<Recyclerview.ViewHolder>() {
    var count = 0
    var color = 0
    inner class ViewHolder(var view: View): RecyclerView.ViewHolder(view){
        var clView = view.findViewById<ConstraintLayout>(R.id.clView)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Recyclerview.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.layout_recyclerview,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Recyclerview.ViewHolder, position: Int) {
//        holder.tvRecyclerView.setText("this is text $position")
        when(color) {
            0 -> holder.clView.setBackgroundColor(ContextCompat.getColor(activity, R.color.Red))
            1 -> holder.clView.setBackgroundColor(ContextCompat.getColor(activity, R.color.Green))
            2 -> holder.clView.setBackgroundColor(ContextCompat.getColor(activity, R.color.Blue))
        }
    }

    override fun getItemCount(): Int {
        return count
    }

    fun updateCount(count: Int){
        this.count = count
        notifyDataSetChanged()
    }
    fun updateColor(color: Int){
        this.color = color
        notifyDataSetChanged()
    }
}