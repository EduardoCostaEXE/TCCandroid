package com.example.dapmotoristas

import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class Navegacao : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
    private lateinit var map: GoogleMap
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var lastLocation: Location

    //Requisita permissão do usuário para acessar a localização dele
    companion object {
        private const val LOCATION_PERMITION_REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navegacao)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapa) as? SupportMapFragment
        mapFragment?.getMapAsync(this)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
    }

    //COLOQUEM AS LOCALIZAÇÕES AQUI
        //1 - CRIEM A VARIÁVEL COM A LATITUDE E A LONGITUDE DA LOCALIZAÇÃO
        //2 - ADICIONEM O MÉTODO DO "googleMap.addMarker" PARA MARCAR NO MAPA
            //.position = nome da variável
            //.title = você que decide HUEHUEHUEHUEUE
    override fun onMapReady(map: GoogleMap) {

        //Faz aparecer os botões de zoom e permite ao usuário interagir melhor
        map.getUiSettings().setZoomControlsEnabled(true)

        val Unip = LatLng(-23.25520814200808, -45.94855886683163)
        val Casa = LatLng(28.3948982,-81.6029011)
        map.addMarker(
            MarkerOptions()
                .position(Unip)
                .title("UNIP")
        )
        map.addMarker(
            MarkerOptions()
                .position(Casa)
                .title("FREEZA! POR QUE VOCÊ MATOU O KURIRIN?")
        )

        //Abrir o mapa centralizado no marcador e com zoom nele
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(Unip, 15.0f))

        setUpMap()
    }

    //Verifica se o usuário permitiu o compartilhamento de localização, caso não tenha, é solicitado novamente
    private fun setUpMap() {
        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMITION_REQUEST_CODE)
            return
        }

        map.isMyLocationEnabled = true

        fusedLocationClient.lastLocation.addOnSuccessListener(this) {  location ->
            if (location != null){
                lastLocation = location
                val currentLatLng = LatLng(location.latitude, location.longitude)
//                Colocar o foco no usuário
//                map.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 14.0f))
            }
        }
    }

    override fun onMarkerClick(p0: Marker) = false
}