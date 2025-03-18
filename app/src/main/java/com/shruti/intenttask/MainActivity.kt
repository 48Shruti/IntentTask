package com.shruti.intenttask

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import com.shruti.intenttask.databinding.ActivityMainBinding
import com.shruti.intenttask.databinding.CustomDialogBinding
import com.shruti.intenttask.fragment_activity_interaction.ActivityInteraction
import com.shruti.intenttask.fragment_activity_interaction.BaseActivity
import com.shruti.intenttask.recycler_view.RecyclerActivity
import com.shruti.intenttask.room_database.RoomActivity
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var booleanList = booleanArrayOf(true, false,false)
    var list = arrayOf("one", "two", "three")
    var simpleDateFormat = SimpleDateFormat("dd/MMM/yyyy", Locale.getDefault())
    val simpleTimeFormat = SimpleDateFormat("hh:mm aa",Locale.getDefault())
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
            Snackbar.make(it, "This is a snackbar", Snackbar.LENGTH_SHORT)
                .setAction("undo", { Toast.makeText(this, "Snackbar undo", Toast.LENGTH_SHORT) })
                .show()
        }
        binding.btnalert.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("This is a title")
                setPositiveButton("yes") { _, _, ->
                    Toast.makeText(this@MainActivity, "yes", Toast.LENGTH_SHORT).show()
                }
                setNegativeButton("no") { _, _, ->
                    Toast.makeText(this@MainActivity, "no", Toast.LENGTH_SHORT).show()
                }
                setNeutralButton("cancel") { _, _, ->
                    Toast.makeText(this@MainActivity, "cancel", Toast.LENGTH_SHORT).show()
                }
                setCancelable(false)
            }.show()
        }
        binding.btnalertSingle.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("this is alert dialog")
                setItems(list) { _, which ->
                    Toast.makeText(this@MainActivity, list[which], Toast.LENGTH_SHORT).show()
                }
                setPositiveButton("yes") { _, _ ->
                    Toast.makeText(this@MainActivity, "yes", Toast.LENGTH_SHORT).show()
                }
                setNegativeButton("no") { _, _ ->
                    Toast.makeText(this@MainActivity, "no", Toast.LENGTH_SHORT).show()
                }
                setCancelable(false)
            }.show()
        }
        binding.btnalertMultiple.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("this is a multiple option alert dialog")
                setMultiChoiceItems(list, booleanList) { _, which, isChecked ->
                    booleanList.set(which, isChecked)
                    Toast.makeText(this@MainActivity, list[which], Toast.LENGTH_SHORT).show()
                }
                setPositiveButton("yes") { _, _ ->
                    android.widget.Toast.makeText(
                        this@MainActivity,
                        "yes",
                        android.widget.Toast.LENGTH_SHORT
                    ).show()
                }
                setNegativeButton("no") { _, _ ->
                    Toast.makeText(this@MainActivity, "no", Toast.LENGTH_SHORT).show()
                }
                setCancelable(false)
            }.show()
        }
        binding.btncustomDialog.setOnClickListener {
            var dialog = Dialog(this)
            dialog.setContentView(R.layout.custom_dialog)
            var dialogBinding = CustomDialogBinding.inflate(layoutInflater)
            dialog.setContentView(dialogBinding.root)
            dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
            dialogBinding.btnclick.setOnClickListener {
                Toast.makeText(this@MainActivity,"it is custom layout ", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            dialog.show()
        }

        binding.btndatePicker.setOnClickListener {
            DatePickerDialog(
                this, { _, year, month, day ->
                    val calender = Calendar.getInstance()
                    calender.set(year, month, day)
                    var formatDate = simpleDateFormat.format(calender.time)
                    binding.btndatePicker.setText(formatDate)
                },
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
            ).show()
        }
        binding.btntimePicker.setOnClickListener {
            TimePickerDialog(
                this, { _, hour, min ->
                    val calendar = Calendar.getInstance()
                    calendar.set(Calendar.HOUR, hour)
                    calendar.set(Calendar.MINUTE, min)
                    val formatTime = simpleTimeFormat.format(calendar.time)
                    binding.btntimePicker.setText(formatTime)
                },
               12,0,false,
            ).show()
        }
        binding.btnSpinner.setOnClickListener {
            val intent = Intent(this,SpinnerActivity::class.java)
            startActivity(intent)
        }
        binding.btnRoomData.setOnClickListener {
            val intent = Intent(this,RoomActivity::class.java)
            startActivity(intent)
        }
        binding.btnList.setOnClickListener {
            val intent = Intent(this,ListActivity::class.java)
            startActivity(intent)
        }
        binding.btnViewPager.setOnClickListener {
            val intent = Intent(this,ViewPagerActivity::class.java)
            startActivity(intent)
        }
        binding.btnUiComponents.setOnClickListener {
            val intent = Intent(this,UiComponentsActivity::class.java)
            startActivity(intent)
        }
        binding.btnFragmentActivityInteraction.setOnClickListener {
            val intent = Intent(this, BaseActivity::class.java)
            startActivity(intent)
        }
        binding.btnrecycler.setOnClickListener {
            val intent = Intent(this,RecyclerActivity::class.java)
            startActivity(intent)
        }
        binding.menu.setOnClickListener {
            var intent = Intent(this,MenuActivity::class.java)
            startActivity(intent)
        }
        binding.btntab.setOnClickListener {
            var intent = Intent(this,TabActivity::class.java)
            startActivity(intent)
        }
        binding.btnweb.setOnClickListener {
            var intent = Intent(this,WebViewActivity::class.java)
            startActivity(intent)
        }
        binding.btnDrawer.setOnClickListener {
            var intent = Intent(this,DrawerActivity::class.java)
            startActivity(intent)
        }
        binding.btnLocation.setOnClickListener {
            val intent = Intent(this, CurrentLocActivity::class.java)
            startActivity(intent)
        }
        binding.btnSharedPref.setOnClickListener {
            val intent = Intent(this,SharedPrefActivity::class.java)
            startActivity(intent)
        }
        binding.btnTool.setOnClickListener {
            val intent = Intent(this, ToolbarActivity::class.java)
            startActivity(intent)
        }
    }
}
