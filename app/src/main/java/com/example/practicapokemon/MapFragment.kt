package com.example.practicapokemon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapFragment : Fragment(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment =
            childFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment?
        mapFragment?.getMapAsync(this)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Obtiene latitud y longitud de los argumentos del Fragment
        val latitud = arguments?.getDouble("latitud", 0.0) ?: 0.0
        val longitud = arguments?.getDouble("longitud", 0.0) ?: 0.0

        // Usa las coordenadas para mostrar el marcador
        val ubicacionPokemon = LatLng(latitud, longitud)
        mMap.addMarker(MarkerOptions().position(ubicacionPokemon).title("Pokémon Aquí"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ubicacionPokemon, 15f)) // Ajusta el zoom según necesites
    }
}
