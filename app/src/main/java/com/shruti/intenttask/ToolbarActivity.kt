package com.shruti.intenttask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.shruti.intenttask.databinding.ActivityTabBinding
import com.shruti.intenttask.databinding.ActivityToolbarBinding

class ToolbarActivity : AppCompatActivity() {
    lateinit var binding : ActivityToolbarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityToolbarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply{
            toolbar.title = "My App"
            toolbar.subtitle = "App layout"


            fab.setOnClickListener {
                val intent = Intent(this@ToolbarActivity, FabActivity::class.java)
                startActivity(intent)

                Toast.makeText(this@ToolbarActivity, "Fab button done", Toast.LENGTH_SHORT).show()
            }
        }


    }
}