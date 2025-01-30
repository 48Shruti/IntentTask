package com.shruti.intenttask.room_database

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shruti.intenttask.R

class RoomAdapter(val item : ArrayList<RoomEntity>,val roomInterface: RoomInterface) : RecyclerView.Adapter<RoomAdapter.ViewHolder>() {
    class ViewHolder(var view: View) : RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_view,parent,false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: RoomAdapter.ViewHolder, position: Int) {
        
    }

    override fun getItemCount(): Int {
        return  item.size
    }
}