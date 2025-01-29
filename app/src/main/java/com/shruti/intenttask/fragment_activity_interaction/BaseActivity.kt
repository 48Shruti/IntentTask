package com.shruti.intenttask.fragment_activity_interaction

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shruti.intenttask.R
import com.shruti.intenttask.databinding.ActivityBaseBinding

class BaseActivity : AppCompatActivity() {
    lateinit var binding : ActivityBaseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.fragmentInteraction.setOnClickListener {
            val intent = Intent(this,ActivityInteraction::class.java)
            startActivity(intent)
        }
        binding.fragmentColor.setOnClickListener {
            val intent = Intent(this,ColorActivity::class.java)
            startActivity(intent)
        }
    }
}