package com.shruti.intenttask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView

class ListAdapter(var arrayList: ArrayList<Student>,var studentInterface: StudentInterface) :BaseAdapter() {
    override fun getCount(): Int {
         return  arrayList.size
    }

    override fun getItem(p0: Int): Any {
        return  1
    }

    override fun getItemId(p0: Int): Long {
        return  1L
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view = LayoutInflater.from(p2?.context).inflate(R.layout.list_view,p2,false)
        val name = view.findViewById<TextView>(R.id.tvname)
        name.setText(arrayList[p0].name)
        val classStudent = view.findViewById<TextView>(R.id.tvclass)
        classStudent.setText(arrayList[p0].classStudent.toString())
        val rollNumber = view.findViewById<TextView>(R.id.tvroll)
        rollNumber.setText(arrayList[p0].rollNo.toString())
        val update = view.findViewById<Button>(R.id.btnupdate)
        update.setOnClickListener {
            studentInterface.update(arrayList[p0],p0)
        }
        val delete = view.findViewById<Button>(R.id.btndelete)
        delete.setOnClickListener {
            studentInterface.delete(arrayList[p0],p0)
        }
        return  view
    }
}