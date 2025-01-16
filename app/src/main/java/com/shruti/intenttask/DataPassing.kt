package com.shruti.intenttask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shruti.intenttask.databinding.ActivityDataPassingBinding

class DataPassing : AppCompatActivity() {
    lateinit var binding: ActivityDataPassingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataPassingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val hello = intent.getStringExtra("data")
        binding.tvhello.setText(hello)
    }
}