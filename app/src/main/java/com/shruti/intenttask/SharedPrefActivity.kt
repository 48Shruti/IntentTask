package com.shruti.intenttask

import android.app.AlertDialog
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.shruti.intenttask.databinding.ActivitySharedPrefBinding

class SharedPrefActivity : AppCompatActivity() {
    lateinit var binding : ActivitySharedPrefBinding
    lateinit var sharedPref : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySharedPrefBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPref = getSharedPreferences("Data", MODE_PRIVATE)  // it will create a file named data in local storage
        val editor = sharedPref.edit()  // editor will used to edit data
        loadData()
        binding.btnSave.setOnClickListener {
            if (binding.etname.text.isNullOrEmpty()){
                binding.etname.error = "Enter name"
            }else{
                editor.putString("name", binding.etname.text.toString())
                editor.apply()
                Toast.makeText(this,"Save Button", Toast.LENGTH_SHORT).show()
            }

        }
        binding.btnDelete.setOnClickListener {
            editor.remove("name")
            editor.apply()
            loadData()
            Toast.makeText(this,"Delete it successfully", Toast.LENGTH_SHORT).show()

        }
        binding.btnAppMode.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("change color mode ")
                setPositiveButton("Dark Mode"){_,_,->
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    editor.putBoolean("dark", true)
                    editor.commit()
                    editor.apply()
                }
                setNegativeButton("Light Mode"){_,_,->
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    editor.putBoolean("dark", false)
                    editor.commit()
                    editor.apply()

                }
            }.show()
            Toast.makeText(this,"App Mode Button", Toast.LENGTH_SHORT).show()

        }
    }
    fun loadData(){
        var name = sharedPref.getString("name","")
        binding.etname.setText(name)
        if (sharedPref.getBoolean("dark",false)){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }
}