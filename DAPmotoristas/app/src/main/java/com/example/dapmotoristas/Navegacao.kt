package com.example.dapmotoristas

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.tomtom.sdk.common.location.GeoCoordinate
import com.tomtom.sdk.common.location.Place
import com.tomtom.sdk.common.route.Route
//Tomtom
import com.tomtom.sdk.maps.display.MapOptions
import com.tomtom.sdk.maps.display.ui.MapFragment
import com.tomtom.sdk.maps.display.TomTomMap
import com.tomtom.sdk.maps.display.location.LocationMarkerOptions
import com.tomtom.sdk.maps.display.location.LocationMarkerType
import com.tomtom.sdk.location.android.AndroidLocationEngine
import com.tomtom.sdk.maps.display.image.ImageFactory
import com.tomtom.sdk.maps.display.marker.MarkerOptions
import com.tomtom.sdk.maps.display.route.Instruction
import com.tomtom.sdk.maps.display.route.RouteOptions
import com.tomtom.sdk.routing.api.*
import com.tomtom.sdk.routing.common.RoutingError
import com.tomtom.sdk.routing.online.OnlineRoutingApi
import com.tomtom.sdk.routing.common.options.Itinerary
import com.tomtom.sdk.routing.common.options.ItineraryPoint
import com.tomtom.sdk.routing.common.options.RoutePlanningOptions
import com.tomtom.sdk.routing.common.options.vehicle.Vehicle

class Navegacao : AppCompatActivity() {
    private lateinit var route: Route
    private lateinit var planRouteOptions: RoutePlanningOptions
    private lateinit var locationEngine: AndroidLocationEngine
    private lateinit var tomTomMap: TomTomMap
    private val APIKEY = "2XhCWUOz93KHvOjIGSoZ6D8liAgYjcrq"
    private lateinit var routingAPI: RoutingApi

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
            .replace(R.id.map_container, mapFragment)
            .commit()

        routingAPI = OnlineRoutingApi.create(context = this, apiKey = APIKEY)
        mapFragment.getMapAsync { map ->
            tomTomMap = map
            enableUserLocation()
            setUpMapListeners()
        }
    }

    //override fun onMapReady(map: TomTomMap) {
    //    this.tomTomMap = map
    //    val pointNagumo = GeoCoordinate(-23.2819211, -45.8949833)
    //    val markerOptions = MarkerOptions(
    //        coordinate = amsterdam,
    //        pinImage = ImageFactory.fromResource(R.drawable.img_escolaridade)
    //    )
    //    this.tomTomMap.addMarker(markerOptions)
    //}

    // LOCALIZAÇÃO EM TEMPO REAL
    private fun enableUserLocation() {
        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMITION_REQUEST_CODE)
            return
        }
        locationEngine = AndroidLocationEngine(context = this)
        locationEngine.enable()

        tomTomMap.setLocationEngine(locationEngine)
        val locationMarker = LocationMarkerOptions(type = LocationMarkerType.CHEVRON)
        tomTomMap.enableLocationMarker(locationMarker)
    }
    // FIM LOCALIZAÇÃO EM TEMPO REAL

    private val planRouteCallback = object : RoutePlanningCallback {
        override fun onSuccess(result: RoutePlanningResult) {
            route = result.routes.first()
            drawRoute(route)
        }

        override fun onError(error: RoutingError) {
            Toast.makeText(this@Navegacao, error.message, Toast.LENGTH_SHORT).show()
        }

        override fun onRoutePlanned(route: Route) {

        }
    }

    private fun Route.mapInstructions(): List<Instruction> {
        val routeInstructions = legs.flatMap { routeLeg -> routeLeg.instructions }
        return routeInstructions.map {
            Instruction(
                routeOffset = it.routeOffset,
                combineWithNext = it.isPossibleToCombineWithNext
            )
        }
    }

    private fun drawRoute(route: Route){
        val instructions = route.mapInstructions()
        val geometry = route.legs.flatMap { it.points }
        val routeOptions = RouteOptions(
            geometry = geometry,
            destinationMarkerVisible = true,
            departureMarkerVisible = true,
            instructions = instructions
        )
        tomTomMap.addRoute(routeOptions)
        val ZOOM_PADDING = 20
        tomTomMap.zoomToRoutes(ZOOM_PADDING)
    }

    private fun createRoute(destination: GeoCoordinate) {

        //LOCALIZAÇÕES
        val pizza1 = ItineraryPoint(Place(GeoCoordinate(-23.193015815750694, -45.89688166682618)))
        val burgerking = ItineraryPoint(Place(GeoCoordinate(-23.19176089996789, -45.89088961164485)))
        val pqSantos = ItineraryPoint(Place(GeoCoordinate(-23.199032693570107, -45.891408764316125)))
        val mcDonalds = ItineraryPoint(Place(GeoCoordinate(-23.19410800212455, -45.893464532579614)))
        val vicentina = ItineraryPoint(Place(GeoCoordinate(-23.197362319153708, -45.89640423381242)))
        val unip = ItineraryPoint(Place(GeoCoordinate(-23.255208142011195, -45.948542773570026)))
        //LOCALIZAÇÕES

        val userLocation = tomTomMap.currentLocation?.position ?: return
        val itinerary = Itinerary(origin = pizza1,
            destination = unip,
            waypoints = listOf(burgerking,pqSantos,mcDonalds,vicentina)
        )

        planRouteOptions = RoutePlanningOptions(
            itinerary = itinerary,
            costModel = null,
            departAt = null,
            arriveAt = null,
            alternativeRoutesOptions = null,
            guidanceOptions = null,
            routeLegOptions = emptyList(),
            vehicle = Vehicle.Van(),
            chargingOptions = null,
            queryOptions = null
        )
        routingAPI.planRoute(planRouteOptions, planRouteCallback)
    }

    private fun setUpMapListeners() {
        tomTomMap.addOnMapClickListener { coordinate: GeoCoordinate ->
            createRoute(coordinate)
            return@addOnMapClickListener true
        }

    }
}