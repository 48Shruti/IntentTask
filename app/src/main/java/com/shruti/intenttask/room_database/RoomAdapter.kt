package com.shruti.intenttask.room_database

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shruti.intenttask.R

class RoomAdapter(val item : ArrayList<RoomEntity>,val roomInterface: RoomInterface) : RecyclerView.Adapter<RoomAdapter.ViewHolder>() {
    class ViewHolder(var view: View) : RecyclerView.ViewHolder(view){
        val nameStudent = view.findViewById<TextView>(R.id.tvname)
        val classStudent = view.findViewById<TextView>(R.id.tvclass)
        val rollStudent = view.findViewById<TextView>(R.id.tvroll)
        val updateStudent = view.findViewById<Button>(R.id.btnupdate)
        val deleteStudent = view.findViewById<Button>(R.id.btndelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_view,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RoomAdapter.ViewHolder, position: Int) {
        holder.nameStudent.setText(item[position].name)
        holder.classStudent.setText(item[position].classNo.toString())
        holder.rollStudent.setText(item[position].rollNo.toString())
        holder.updateStudent.setOnClickListener {
            roomInterface.update(item[position],position)
        }
        holder.deleteStudent.setOnClickListener {
            roomInterface.delete(item[position],position)
        }
    }

    override fun getItemCount(): Int {
        return  item.size
    }
}