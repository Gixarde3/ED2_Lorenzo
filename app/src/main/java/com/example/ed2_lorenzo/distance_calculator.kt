package com.example.ed2_lorenzo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlin.math.*

class distance_calculator : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    private lateinit var originEditText: EditText
    private lateinit var destinationEditText: EditText
    private lateinit var calculateButton: Button
    private lateinit var resultTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_distance_calculator)
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        destinationEditText = findViewById(R.id.destinationEditText)
        calculateButton = findViewById(R.id.calculateButton)
        resultTextView = findViewById(R.id.resultTextView)

        calculateButton.setOnClickListener {
            calculateDistance()
        }
    }
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
    }

    private fun calculateDistance() {
        val destination = destinationEditText.text.toString().split(",")

        if (destination.size != 2) {
            resultTextView.text = "Formato inválido. Use: latitud,longitud"
            return
        }


        val destLatLng = LatLng(destination[0].toDouble(), destination[1].toDouble())

        mMap.clear()
        mMap.addMarker(MarkerOptions().position(destLatLng).title("Destino"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(destLatLng, 10f))

    }
}