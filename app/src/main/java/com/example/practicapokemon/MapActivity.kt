package com.example.practicapokemon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MapActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapa)

        // Obtiene latitud y longitud enviadas a través del Intent
        val latitud = intent.getDoubleExtra("latitud", 0.0)
        val longitud = intent.getDoubleExtra("longitud", 0.0)

        // Carga el MapFragment y pasa las coordenadas como argumentos
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.map_container, MapFragment().apply {
                    arguments = Bundle().apply {
                        putDouble("latitud", latitud)
                        putDouble("longitud", longitud)
                    }
                })
                commit()
            }
        }
    }
}
