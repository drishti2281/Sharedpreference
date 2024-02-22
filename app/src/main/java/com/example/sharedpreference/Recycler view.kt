package com.example.sharedpreference

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.core.graphics.red
import androidx.recyclerview.widget.RecyclerView

class BaseAdapter(var arrayList: ArrayList<Int>)  : BaseAdapter() {
    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(position: Int): Any {
        return arrayList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var initView = LayoutInflater.from(parent?.context).inflate(R.layout.fragment_shared_perfs, parent,false)
        var btnRed = initView.findViewById<TextView>(R.id.btnRed)
        btnRed.setText(arrayList[position])
        return initView
    }

}

class Recyclerview(var list : ArrayList<Int>) : RecyclerView.Adapter<Recyclerview.ViewHolder>() {
    class ViewHolder(var views: View) : RecyclerView.ViewHolder(views) {
        var btnRed = views.findViewById<TextView>(R.id.btnRed)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        lateinit var view: View
        if (viewType == 0) {
            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_shared_perfs, parent, false)
        }
        return ViewHolder(view)
    }


    override fun getItemViewType(position: Int): Int {
//        return if(position%2 == 0)
//            0
//        else 1
//        return super.getItemViewType(position)
        return if (list[position].toInt() == 0) {
            0
        } else 1
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //set values here
        holder.btnRed.setText(list[position].red)
    }
}