package com.example.dapmotoristas

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
//Tomtom
import com.tomtom.sdk.maps.display.MapOptions
import com.tomtom.sdk.maps.display.ui.MapFragment
import com.tomtom.sdk.maps.display.TomTomMap
import com.tomtom.sdk.location.android.AndroidLocationEngine
import com.tomtom.sdk.maps.display.location.LocationMarkerOptions
import com.tomtom.sdk.maps.display.location.LocationMarkerType
import com.tomtom.sdk.routing.api.description.SectionType
import com.tomtom.sdk.routing.api.guidance.AnnouncementPoints
import com.tomtom.sdk.routing.api.guidance.InstructionPhoneticsType
import com.tomtom.sdk.routing.api.guidance.InstructionType
import com.tomtom.sdk.routing.online.OnlineRoutingApi
import com.tomtom.sdk.common.location.GeoCoordinate
import com.tomtom.sdk.common.route.Route
import com.tomtom.sdk.common.route.section.travelmode.TravelMode
import com.tomtom.sdk.routing.api.*

class Navegacao : AppCompatActivity() {

    private lateinit var route: Route
    private lateinit var locationEngine: AndroidLocationEngine
    private lateinit var tomTomMap: TomTomMap
    private lateinit var planRouteOptions: PlanRouteOptions
    private val APIKEY = "2XhCWUOz93KHvOjIGSoZ6D8liAgYjcrq"
    private val routingAPI = OnlineRoutingApi.create(context = this, apiKey = APIKEY)



    companion object {
        private const val LOCATION_PERMITION_REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navegacao)
        setUpMap()

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

    // LOCALIZAÇÃO EM TEMPO REAL
    private fun enableUserLocation() {
        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMITION_REQUEST_CODE)
            return
        }
        locationEngine = AndroidLocationEngine(context = this)
        locationEngine.enable()

        tomTomMap.setLocationEngine(locationEngine)
        val locationMarker = LocationMarkerOptions(type=LocationMarkerType.CHEVRON)
        tomTomMap.enableLocationMarker(locationMarker)
    }
    // LOCALIZAÇÃO EM TEMPO REAL

    //CRIAR ROTA
    private val planRouteCallback = object : PlanRouteCallback {
        override fun onSucess(result: PlanRouteResult) {
            route = result.routes.first()
            drawRoute(route !!)
        }

        override fun onError(error: RoutingError) {
            Toast.makeText(this@Navegacao, error.message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun drawRoute(route: Route){
    }

    private fun createRoute(destination: GeoCoordinate) {
        val userLocation = tomTomMap.currentLocation?.position ?: return
        val itinerary = Itinerary(origin = userLocation, destination = destination)
        planRouteOptions = PlanRouteOptions(
            itinerary = itinerary,
            instructionType = InstructionType.TEXT,
            instructionPhonetics = InstructionPhoneticsType.IPA,
            instructionAnnouncementPoints = AnnouncementPoints.ALL,
            sectionTypes = listOf(SectionType.MOTORWAY, SectionType.LANES, SectionType.SPEED_LIMIT),
            travelMode = TravelMode.VAN
        )
        routingAPI.planRoute(planRouteOptions, planRouteCallback)
    }

    private fun setUpMapListeners() {
    }

    // PEDIR PRA COMPARTILHAR LOCALIZAÇÃO
    private fun setUpMap() {

    }
    // PEDIR PRA COMPARTILHAR LOCALIZAÇÃO
}