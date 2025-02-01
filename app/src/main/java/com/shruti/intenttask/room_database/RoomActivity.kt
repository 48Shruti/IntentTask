package com.shruti.intenttask.room_database

import android.app.Dialog
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.shruti.intenttask.databinding.ActivityRoomBinding
import com.shruti.intenttask.databinding.CustomDialogBinding

class RoomActivity : AppCompatActivity(),RoomInterface {
    lateinit var databasePractice: RoomDatabasePractice
    lateinit var binding : ActivityRoomBinding
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var gridLayout: GridLayoutManager
    var item = ArrayList<RoomEntity>()
    lateinit var roomAdapter: RoomAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)
        roomAdapter = RoomAdapter(item,this)
        linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        gridLayout = GridLayoutManager(this,2)
        binding.recycler.adapter = roomAdapter
        binding.recycler.layoutManager = gridLayout
        databasePractice = RoomDatabasePractice.getDatabase(this)
        binding.fab.setOnClickListener {
            val dialog = Dialog(this)
            val dialogBinding = CustomDialogBinding.inflate(layoutInflater)
            dialog.setContentView(dialogBinding.root)
            dialog.window?.setLayout(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT)
            dialogBinding.btnclick.setOnClickListener {
                if (dialogBinding.etname.text.isNullOrEmpty()){
                    dialogBinding.etname.error = "Enter name"
                }else if (dialogBinding.etclass.text.isNullOrEmpty()){
                    dialogBinding.etclass.error = "Enter class"
                } else if (dialogBinding.etroll.text.isNullOrEmpty()){
                    dialogBinding.etroll.error = "Enter roll number"
                }else{
                    class insert : AsyncTask<Void, Void, Void>() {
                        override fun doInBackground(vararg p0: Void?): Void? {
                            databasePractice.roomDao().insertNotes(RoomEntity(
                                name = dialogBinding.etname.text.toString(),
                                classNo = dialogBinding.etclass.text.toString().toInt(),
                                rollNo = dialogBinding.etroll.text.toString().toInt()))
                            return null
                        }
                        override fun onPostExecute(result: Void?) {
                            super.onPostExecute(result)
                            getNotes()
                        }
                    }
                    insert().execute()
                    dialog.dismiss()
                    roomAdapter.notifyDataSetChanged()
                }
            }
            dialog.show()
        }
        getNotes()
    }
     fun getNotes(){
         item.clear()
         class getNotes : AsyncTask<Void,Void,Void>() {
             override fun doInBackground(vararg p0: Void?): Void? {
                 item.addAll(databasePractice.roomDao().getNotes())
                 return  null
             }

             override fun onPostExecute(result: Void?) {
                 super.onPostExecute(result)
                 roomAdapter.notifyDataSetChanged()
             }
         }
         getNotes().execute()
     }

    override fun update(roomEntity: RoomEntity,position:Int) {
        val dialog = Dialog(this)
        val dialogBinding = CustomDialogBinding.inflate(layoutInflater)
        dialog.setContentView(dialogBinding.root)
        dialog.window?.setLayout(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT)
        dialogBinding.btnclick.setText("Update")
        dialogBinding.etclass.setText(item[position].classNo.toString())
        dialogBinding.etroll.setText(item[position].rollNo.toString())
        dialogBinding.etname.setText(item[position].name)
        dialogBinding.btnclick.setOnClickListener {
            if (dialogBinding.etname.text.isNullOrEmpty()){
                dialogBinding.etname.error = "Enter name"
            }else if (dialogBinding.etclass.text.isNullOrEmpty()){
                dialogBinding.etclass.error = "Enter class"
            } else if (dialogBinding.etroll.text.isNullOrEmpty()){
                dialogBinding.etroll.error = "Enter roll number"
            }else{
//                item.set(position, RoomEntity( name = dialogBinding.etname.text.toString(),
//                    classNo = dialogBinding.etclass.text.toString().toInt(),
//                    rollNo = dialogBinding.etroll.text.toString().toInt()))
                class update : AsyncTask<Void, Void, Void>() {
                    override fun doInBackground(vararg p0: Void?): Void? {
                        databasePractice.roomDao().updateNotes(RoomEntity(
                            id = item[position].id,
                            name = dialogBinding.etname.text.toString(),
                            classNo = dialogBinding.etclass.text.toString().toInt(),
                            rollNo = dialogBinding.etroll.text.toString().toInt()))
                        return null
                    }
                    override fun onPostExecute(result: Void?) {
                        super.onPostExecute(result)
                        getNotes()
                    }
                }
                update().execute()
                dialog.dismiss()
                roomAdapter.notifyDataSetChanged()
            }
        }
        dialog.show()
    }

    override fun delete(roomEntity: RoomEntity,position: Int) {
        class delete : AsyncTask<Void,Void,Void>() {
            override fun doInBackground(vararg p0: Void?): Void? {
                databasePractice.roomDao().deleteNotes(item[position])
                return null
            }

            override fun onPostExecute(result: Void?) {
                super.onPostExecute(result)
                getNotes()
            }
        }
        delete().execute()
        roomAdapter.notifyDataSetChanged()
    }
}