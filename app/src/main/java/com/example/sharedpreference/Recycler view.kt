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
abstract class Recyclerview (var activity: MainActivity ): RecyclerView.Adapter<Recyclerview.ViewHolder>(),
    Parcelable {

    var count = 0
    var color = 0


    inner class ViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var clView = view.findViewById<ConstraintLayout>(R.id.clView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Recyclerview.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.layout_recyclerview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Recyclerview.ViewHolder, position: Int) {
        when (color) {
            0 -> holder.clView.setBackgroundColor(ContextCompat.getColor(activity, R.color.Red))
            1 -> holder.clView.setBackgroundColor(ContextCompat.getColor(activity, R.color.Green))
            2 -> holder.clView.setBackgroundColor(ContextCompat.getColor(activity, R.color.Blue))
        }

    }

    override fun getItemCount(): Int {
        return count
    }

    fun updateCount(count: Int) {
        this.count = count
        notifyDataSetChanged()
    }

    fun updateColor(color: Int) {
       this.color = color
        notifyDataSetChanged()
    }
}
//class BaseAdapter(var arrayList: ArrayList<String>)  : BaseAdapter() {
   override fun getCount(): Int {
        return arrayList.size
    }

  override fun getItem(position: Int): Any {
      return arrayList[position]
    }

    override fun getItemId(position: Int): Long { return position.toLong()
   }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
      var initView = LayoutInflater.from(parent?.context).inflate(R.layout.fragment_shared_perfs, parent,false)
       var btnRed = initView.findViewById<TextView>(R.id.btnRed)
        btnRed.setText(arrayList[position])
        return initView
    }
 //   }

//class Recyclerview(var list : ArrayList<Int>) : RecyclerView.Adapter<Recyclerview.ViewHolder>() {
  //  class ViewHolder(var views: View) : RecyclerView.ViewHolder(views) {
    //    var btnRed = views.findViewById<TextView>(R.id.btnRed)
    //}

   // override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
 //       lateinit var view: View
     //   if (viewType == 0) {
       //     view = LayoutInflater.from(parent.context)
         //       .inflate(R.layout.fragment_shared_perfs, parent, false)
        //}
        //return ViewHolder(view)
    //}


    //override fun getItemViewType(position: Int): Int {
//        return if(position%2 == 0)
//            0
//        else 1
//        return super.getItemViewType(position)
      //  return if (list[position].toInt() == 0) {
        //    0
        //} else 1
    //}

   // override fun getItemCount(): Int {
    //    return list.size
    //}

   // override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //set values here
     //   holder.btnRed.setText(list[position].red)
    //}
//}