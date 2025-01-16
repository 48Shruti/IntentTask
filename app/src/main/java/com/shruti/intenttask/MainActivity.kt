package com.shruti.intenttask

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import com.shruti.intenttask.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var list = arrayOf("one", "two", "three")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnurl.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https::/o7services.com"))
            startActivity(intent)
        }
        binding.btncall.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.setData(Uri.parse("tel:7986167192"))
            startActivity(intent)
        }
        binding.btnemail.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("mailto:shrutisharma86048@gmail.com"))
            startActivity(intent)
        }
        binding.btnsms.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("sms:7986167192"))
            startActivity(intent)
        }
        binding.btndatapassing.setOnClickListener {
            val intent = Intent(this, DataPassing::class.java)
            intent.putExtra("data", binding.ettext.text.toString())
            startActivity(intent)
        }
        binding.btnsnackbar.setOnClickListener {
            Snackbar.make(it,"This is a snackbar", Snackbar.LENGTH_SHORT)
                .setAction("undo", {Toast.makeText(this,"Snackbar undo",Toast.LENGTH_SHORT)})
                .show()
        }
        binding.btnalert.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("This is a title")
                setPositiveButton("yes"){_,_,->
                    Toast.makeText(this@MainActivity,"yes",Toast.LENGTH_SHORT).show()
                }
                setNegativeButton("no"){_,_,->
                    Toast.makeText(this@MainActivity,"no",Toast.LENGTH_SHORT).show()
                }
                setNeutralButton("cancel"){_,_,->
                    Toast.makeText(this@MainActivity,"cancel",Toast.LENGTH_SHORT).show()
                }
                setCancelable(false)
            }.show()
        }
        binding.alertSingle.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("this is alert dialog")
                setItems(list){_,which->
                    Toast.makeText(this@MainActivity,list[which], Toast.LENGTH_SHORT).show()
                }
                setPositiveButton("yes"){_,_->
                    Toast.makeText(this@MainActivity,"yes", Toast.LENGTH_SHORT).show()
                }
                setNegativeButton("no"){_,_->
                    Toast.makeText(this@MainActivity,"no", Toast.LENGTH_SHORT).show()
                }
                setCancelable(false)
            }.show()
        }

    }
}