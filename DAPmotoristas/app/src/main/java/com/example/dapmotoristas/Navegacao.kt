package com.example.dapmotoristas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
    private lateinit var fusedLocationClient: FusedLocationProviderClient

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
    override fun onMapReady(googleMap: GoogleMap) {
        googleMap.getUiSettings().setZoomControlsEnabled(true)
        googleMap.setOnMarkerClickListener(this)

        val Unip = LatLng(-23.2336196, -45.9598745)
        val Casa = LatLng(28.3948982,-81.6029011)
        googleMap.addMarker(
            MarkerOptions()
                .position(Unip)
                .title("TCC")
        )
        googleMap.addMarker(
            MarkerOptions()
                .position(Casa)
                .title("FREEZA! POR QUE VOCÊ MATOU O KURIRIN?")
        )

        googleMap.moveCamera(CameraUpdateFactory.newLatLng(Casa))
    }

    override fun onMarkerClick(p0: Marker) = false
}