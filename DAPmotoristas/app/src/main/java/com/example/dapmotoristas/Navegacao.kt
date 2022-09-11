package com.example.dapmotoristas

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
//Tomtom
import com.tomtom.sdk.maps.display.MapOptions
import com.tomtom.sdk.maps.display.ui.MapFragment
import com.tomtom.sdk.maps.display.TomTomMap

class Navegacao : AppCompatActivity() {

    private lateinit var tomTomMap: TomTomMap
    private val APIKEY = "2XhCWUOz93KHvOjIGSoZ6D8liAgYjcrq"

    companion object {
        private const val LOCATION_PERMITION_REQUEST_CODE = 1
    }


    private fun setUpMap() {
        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMITION_REQUEST_CODE)
            return
        }
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navegacao)

        //Add map fragment
        val mapOptions = MapOptions(mapKey = APIKEY)
        val mapFragment = MapFragment.newInstance(mapOptions)
        supportFragmentManager.beginTransaction()
            .replace(R.id.map, mapFragment)
            .commit()

        mapFragment.getMapAsync { map ->
            tomTomMap = map
            enableUserLocation()
            setUpMapListeners()
        }
    }
    
    private fun enableUserLocation() {
    }

    private fun setUpMapListeners() {
    }

}