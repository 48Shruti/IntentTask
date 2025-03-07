package com.shruti.intenttask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.shruti.intenttask.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    lateinit var binding : ActivityMenuBinding
    lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var navController: NavController
    lateinit var mainMenu : Unit
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = findNavController(R.id.navControllerMenu)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController,appBarConfiguration)
        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.firstFragment -> {
                    navController.navigate(R.id.firstFragment2)
                    navController.popBackStack(R.id.secondFragment2,true)
                }
                R.id.secondFragment -> {
                    navController.navigate(R.id.action_firstFragment2_to_secondFragment22)
                }
            }
                return@setOnItemSelectedListener true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        mainMenu = menuInflater.inflate(R.menu.item_menu,menu)
        return  true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.first -> {
                navController.navigate(R.id.firstFragment2)
                navController.popBackStack(R.id.secondFragment2,true)
                return true
            }
            R.id.second -> {
                navController.navigate(R.id.action_firstFragment2_to_secondFragment22)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        return super.onSupportNavigateUp() || navController.popBackStack()
    }
//    override fun onBackPressed() {
//        if (!navController.popBackStack()) {
//            super.onBackPressed()
//        }
//    }



}