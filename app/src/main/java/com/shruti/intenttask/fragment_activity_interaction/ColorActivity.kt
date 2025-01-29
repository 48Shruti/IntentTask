package com.shruti.intenttask.fragment_activity_interaction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shruti.intenttask.R
import com.shruti.intenttask.databinding.ActivityColorBinding

class ColorActivity : AppCompatActivity() {
    lateinit var binding : ActivityColorBinding
    var colorInterface: ColorInterface ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityColorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnYellow.setOnClickListener {
            colorInterface?.changeColorYellow()
        }
        binding.btnBlue.setOnClickListener {
            colorInterface?.changeColorBlue()
        }
        binding.btnGreen.setOnClickListener {
            colorInterface?.changeColorGreen()
        }
    }
}