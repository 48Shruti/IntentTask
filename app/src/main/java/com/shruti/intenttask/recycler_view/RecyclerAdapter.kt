package com.shruti.intenttask.recycler_view

import android.icu.text.Transliterator.Position
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shruti.intenttask.R

class RecyclerAdapter(var items : ArrayList<RecyclerData>, var clickInterface: onClick) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){
    class ViewHolder(val view : View) : RecyclerView.ViewHolder(view){
        var nameRoom = view.findViewById<TextView>(R.id.tvname)
        var className = view.findViewById<TextView>(R.id.tvclass)
        var rollNum = view.findViewById<TextView>(R.id.tvroll)
        var btnUpdate = view.findViewById<Button>(R.id.btnupdate)
        var btnDelete = view.findViewById<Button>(R.id.btndelete)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_view,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameRoom.setText(items[position].name)
        holder.className.setText(items[position].classStudent.toString())
        holder.rollNum.setText(items[position].rollNo.toString())
        holder.btnUpdate.setOnClickListener {
            clickInterface.update(position)
        }
        holder.btnDelete.setOnClickListener {
            clickInterface.delete(position)
        }
    }
    interface  onClick{
        fun update(position: Int)
        fun delete(position: Int)
    }

}