package com.shruti.intenttask.recycler_view

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.shruti.intenttask.R
import com.shruti.intenttask.databinding.ActivityRecyclerBinding
import com.shruti.intenttask.databinding.CustomDialogBinding

class RecyclerActivity : AppCompatActivity(),RecyclerAdapter.onClick {
    lateinit var binding : ActivityRecyclerBinding
    var item = arrayListOf<RecyclerData>()
    lateinit var recyclerAdapter: RecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerAdapter = RecyclerAdapter(item,this)
        binding.recycler.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.recycler.adapter = recyclerAdapter
        item.add(RecyclerData(name = "Shruti",classStudent = 10, rollNo = 56))
        item.add(RecyclerData(name = "Roma",classStudent = 11, rollNo = 57))
        item.add(RecyclerData(name = "Ridham",classStudent = 10, rollNo = 58))
        item.add(RecyclerData(name = "Vanshika",classStudent = 11, rollNo = 60))

        binding.fab.setOnClickListener {
            val dialog = Dialog(this)
            val dialogBinding = CustomDialogBinding.inflate(layoutInflater)
            dialog.setContentView(dialogBinding.root)
            dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            dialogBinding.btnclick.setOnClickListener {
                if (dialogBinding.etname.text.isNullOrEmpty()) {
                    dialogBinding.etname.error = "Enter name"
                } else if (dialogBinding.etroll.text.isNullOrEmpty()) {
                    dialogBinding.etroll.error = "Enter roll"
                } else if (dialogBinding.etclass.text.isNullOrEmpty()) {
                    dialogBinding.etclass.error = "Enter class"
                } else {
                    item.add(
                        RecyclerData(
                            name = dialogBinding.etname.text.toString(),
                            classStudent = dialogBinding.etclass.text.toString().toInt(),
                            rollNo = dialogBinding.etroll.text.toString().toInt()
                        )
                    )
                    recyclerAdapter.notifyDataSetChanged()
                    dialog.dismiss()
                }
            }
            dialog.show()
        }
    }

    override fun update(position: Int) {
        val dialog = Dialog(this)
        val dialogBinding = CustomDialogBinding.inflate(layoutInflater)
        dialog.setContentView(dialogBinding.root)
        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
        dialogBinding.btnclick.setText("Update")
        dialogBinding.etname.setText(item[position].name)
        dialogBinding.etroll.setText(item[position].rollNo.toString())
        dialogBinding.etclass.setText(item[position].classStudent.toString())
        dialogBinding.btnclick.setOnClickListener {
            if (dialogBinding.etname.text.isNullOrEmpty()) {
                dialogBinding.etname.error = "Enter name"
            } else if (dialogBinding.etroll.text.isNullOrEmpty()) {
                dialogBinding.etroll.error = "Enter roll"
            } else if (dialogBinding.etclass.text.isNullOrEmpty()) {
                dialogBinding.etclass.error = "Enter class"
            } else {
                item.set(
                    position,
                    RecyclerData(
                        name = dialogBinding.etname.text.toString(),
                        classStudent = dialogBinding.etclass.text.toString().toInt(),
                        rollNo = dialogBinding.etroll.text.toString().toInt()
                    )
                )
                recyclerAdapter.notifyDataSetChanged()
                dialog.dismiss()
            }
        }
        dialog.show()
    }

    override fun delete(position: Int) {
        item.removeAt(position)
        recyclerAdapter.notifyDataSetChanged()
    }
}