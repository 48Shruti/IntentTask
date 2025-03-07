package com.shruti.intenttask

import android.content.pm.PackageManager
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.shruti.intenttask.databinding.ActivityCurrentLocBinding
import java.io.IOException
import java.util.Locale

class CurrentLocActivity : AppCompatActivity() {
    lateinit var binding : ActivityCurrentLocBinding
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private val LOCATION_PERMISSION_REQUEST_CODE = 1000
    var pgbar : ProgressBar ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCurrentLocBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        pgbar = findViewById(R.id.progress)
        if (checkPermission()){
            getLastLocation()
        }else{
            requestPermission()
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode){
            LOCATION_PERMISSION_REQUEST_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    getLastLocation()
                }else{
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    fun checkPermission():Boolean{
        return ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
    }
    fun requestPermission(){
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION),
            LOCATION_PERMISSION_REQUEST_CODE)
    }
    fun getLastLocation(){
        pgbar?.visibility = View.VISIBLE
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            return
        }
        fusedLocationProviderClient.lastLocation.addOnSuccessListener {
            pgbar?.visibility = View.GONE
            if (it != null){
                var userLong = it.longitude
                var userLati = it.latitude
                var address = getCompleteAddressStrinng(userLati,userLong)
                binding.setLocation.setText(address)
                binding.setLatitude.setText(userLati.toString())
                binding.setLongitude.setText(userLong.toString())

            }
        }
    }
    private fun getCompleteAddressStrinng(LATITUDE : Double, LONGITUDE: Double):String{
        val geocoder = Geocoder(this, Locale.getDefault())
            try {
                val address = geocoder.getFromLocation(LATITUDE,LONGITUDE,1)
                if (address != null && address.isNotEmpty()){
                    val adress = address[0]
                    val adressString = adress.getAddressLine(0)
                    val placeIdIndex = adressString.indexOf("")
                    if (placeIdIndex != -1){
                        return adressString.substring(placeIdIndex +1)
                    }
                    else{
                        return adressString
                    }
                }
            }catch (e:IOException){
                e.printStackTrace()
            }
            return "No Address found"
        }
    }
