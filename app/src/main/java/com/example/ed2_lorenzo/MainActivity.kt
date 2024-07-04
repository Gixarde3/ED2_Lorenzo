package com.example.ed2_lorenzo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ed2_lorenzo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val btnCalculate = binding.btnCalcularDistancia
        val btnActualLocation = binding.btnLocalizacionActual

        btnCalculate.setOnClickListener {
            val intent = Intent(this, distance_calculator::class.java)
            startActivity(intent)
        }

        btnActualLocation.setOnClickListener {
            val intent = Intent(this, current_location::class.java)
            startActivity(intent)
        }
    }
}