package com.shruti.intenttask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.shruti.intenttask.databinding.ActivityToolbarBinding

class FabActivity : AppCompatActivity() {
    lateinit var binding : ActivityToolbarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityToolbarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            toolbar.title = "My app"
            toolbar.subtitle = "Its working"
            toolbar.setNavigationOnClickListener {
                Toast.makeText(this@FabActivity, "Working", Toast.LENGTH_SHORT).show()
            }
        }
    }
}