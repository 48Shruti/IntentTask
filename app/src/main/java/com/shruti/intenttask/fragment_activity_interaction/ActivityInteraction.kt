package com.shruti.intenttask.fragment_activity_interaction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.shruti.intenttask.R
import com.shruti.intenttask.databinding.ActivityInteractionBinding

class ActivityInteraction : AppCompatActivity() {
    lateinit var binding : ActivityInteractionBinding
    var fragmentActivityInterface: FragmentActivityInterface ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInteractionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnActivity.setOnClickListener {
            fragmentActivityInterface?.changeColor()
        }
    }
    fun changeColorActivity(){
        binding.activity.setBackgroundColor(ContextCompat.getColor(this,R.color.yellow))
    }
}