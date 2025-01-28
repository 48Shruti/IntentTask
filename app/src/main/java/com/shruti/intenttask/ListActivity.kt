package com.shruti.intenttask

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shruti.intenttask.databinding.ActivityListBinding
import com.shruti.intenttask.databinding.CustomDialogBinding
import com.shruti.intenttask.databinding.CustomDialogListBinding

class ListActivity : AppCompatActivity() , StudentInterface{
    lateinit var binding : ActivityListBinding
    var arrayList = arrayListOf<Student>()
    lateinit var listAdapter: ListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listAdapter = ListAdapter(arrayList, this)
        binding.list.adapter = listAdapter
        binding.fab.setOnClickListener {
            val dialog = Dialog(this)
            val dialogBinding = CustomDialogListBinding.inflate(layoutInflater)
            dialog.setContentView(dialogBinding.root)
            dialogBinding.btnadd.setOnClickListener {
                if (dialogBinding.etname.text.isNullOrEmpty()){
                    dialogBinding.etname.error = "Enter name"
                } else  if (dialogBinding.etroll.text.isNullOrEmpty()){
                    dialogBinding.etroll.error = "Enter roll"
                }else  if (dialogBinding.etclass.text.isNullOrEmpty()){
                    dialogBinding.etclass.error = "Enter class"
                }else{
                    arrayList.add(Student(dialogBinding.etname.text.toString(),
                        dialogBinding.etclass.text.toString().toInt(), dialogBinding.etroll.text.toString().toInt()))
                        listAdapter.notifyDataSetChanged()
                    dialog.dismiss()
                }
            }
            dialog.show()
        }
    }

    override fun update(student: Student, position: Int) {
        val dialog = Dialog(this)
        val dialogBinding = CustomDialogListBinding.inflate(layoutInflater)
        dialog.setContentView(dialogBinding.root)
        dialogBinding.etname.setText(arrayList[position].name)
        dialogBinding.etclass.setText(arrayList[position].classStudent.toString())
        dialogBinding.etroll.setText(arrayList[position].rollNo.toString())
        dialogBinding.btnadd.setOnClickListener {
            if (dialogBinding.etname.text.isNullOrEmpty()){
                dialogBinding.etname.error = "Enter name"
            } else  if (dialogBinding.etroll.text.isNullOrEmpty()){
                dialogBinding.etroll.error = "Enter roll"
            }else  if (dialogBinding.etclass.text.isNullOrEmpty()){
                dialogBinding.etclass.error = "Enter class"
            }else{
                arrayList.set(position,Student(dialogBinding.etname.text.toString(),
                    dialogBinding.etclass.text.toString().toInt(), dialogBinding.etroll.text.toString().toInt()))
                listAdapter.notifyDataSetChanged()
                dialog.dismiss()
            }
        }
        dialog.show()
    }

    override fun delete(student: Student, position: Int) {
        arrayList.removeAt(position)
        listAdapter.notifyDataSetChanged()
    }
}