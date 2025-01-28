package com.shruti.intenttask

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shruti.intenttask.databinding.ActivitySpinnerBinding
import com.shruti.intenttask.databinding.CustomDialogBinding

class SpinnerActivity : AppCompatActivity() {
    lateinit var binding : ActivitySpinnerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpinnerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnclick.setOnClickListener {
            val dialog = Dialog(this)
            dialog.setContentView(R.layout.custom_dialog)
            val dialogBinding = CustomDialogBinding.inflate(layoutInflater)
            dialog.setContentView(dialogBinding.root)

        }
    }
}