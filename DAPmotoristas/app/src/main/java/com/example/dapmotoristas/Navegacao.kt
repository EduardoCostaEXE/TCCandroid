package com.example.dapmotoristas

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.tomtom.sdk.common.location.GeoCoordinate
import com.tomtom.sdk.common.route.section.travelmode.TravelMode
import com.tomtom.sdk.location.android.AndroidLocationEngine
//Tomtom
import com.tomtom.sdk.maps.display.MapOptions
import com.tomtom.sdk.maps.display.ui.MapFragment
import com.tomtom.sdk.maps.display.TomTomMap
import com.tomtom.sdk.maps.display.location.LocationMarkerOptions
import com.tomtom.sdk.maps.display.location.LocationMarkerType
import com.tomtom.sdk.routing.common.options.Itinerary
import com.tomtom.sdk.routing.common.options.description.SectionType
import com.tomtom.sdk.routing.common.options.guidance.AnnouncementPoints
import com.tomtom.sdk.routing.common.options.guidance.InstructionPhoneticsType
import com.tomtom.sdk.routing.common.options.guidance.InstructionType
import com.tomtom.sdk.routing.online.OnlineRoutingApi

class Navegacao : AppCompatActivity() {

    private lateinit var locationEngine: AndroidLocationEngine
    private lateinit var tomTomMap: TomTomMap
    private val APIKEY = "2XhCWUOz93KHvOjIGSoZ6D8liAgYjcrq"

    private val routingAPI = OnlineRoutingApi.create(context = this, apiKey = APIKEY)

    //Requisita permissão do usuário para acessar a localização dele
    companion object {
        private const val LOCATION_PERMITION_REQUEST_CODE = 1
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
        locationEngine = AndroidLocationEngine(context = this)
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED) {
            return
        }


        locationEngine.enable()

        tomTomMap.setLocationEngine(locationEngine)
        val locationMarker = LocationMarkerOptions(type= LocationMarkerType.POINTER)
        tomTomMap.enableLocationMarker(locationMarker)
    }

    private fun setUpMapListeners() {

    }



}