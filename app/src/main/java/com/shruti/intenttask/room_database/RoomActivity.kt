package com.shruti.intenttask.room_database

import android.app.Dialog
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shruti.intenttask.databinding.ActivityRoomBinding
import com.shruti.intenttask.databinding.CustomDialogBinding

class RoomActivity : AppCompatActivity() {
    lateinit var databasePractice: RoomDatabasePractice
    lateinit var binding : ActivityRoomBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)
        databasePractice = RoomDatabasePractice.getDatabase(this)
        binding.fab.setOnClickListener {
            val dialog = Dialog(this)
            val dialogBinding = CustomDialogBinding.inflate(layoutInflater)
            dialog.setContentView(dialogBinding.root)
            dialogBinding.btnclick.setOnClickListener {
                if (dialogBinding.etname.text.isNullOrEmpty()){
                    dialogBinding.etname.error = "Enter name"
                }else if (dialogBinding.etclass.text.isNullOrEmpty()){
                    dialogBinding.etclass.error = "Enter class"
                } else if (dialogBinding.etroll.text.isNullOrEmpty()){
                    dialogBinding.etroll.error = "Enter roll number"
                }else{
//                    class insert : AsyncTask<Void, Void, Void>() {
//                        override fun doInBackground(vararg p0: Void?): Void? {
//                            databasePractice.roomInterface().add(
//                                RoomEntity(name = dialogBinding.etname.text.toString(),
//                                classNo = dialogBinding.etclass.text.toString().toInt(),
//                                rollNo = dialogBinding.etroll.text.toString().toInt())
//                            )
//                        }
//                    }
                }
            }
            dialog.show()
        }
    }
}