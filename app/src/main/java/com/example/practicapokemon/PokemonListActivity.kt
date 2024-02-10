package com.example.practicapokemon

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.practicapokemon.database.modelo.Pokemon
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import java.nio.charset.Charset


class PokemonListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_list)

        val json = loadJSONFromAsset(this, "pokemon.json")
        val gson = Gson()
        val type = object : TypeToken<List<Pokemon>>() {}.type
        val pokemonList = gson.fromJson<List<Pokemon>>(json, type)
        val recyclerView: RecyclerView = findViewById(R.id.pokemonRecyclerView)
        // Corrección aplicada aquí
        val adapter = PokemonAdapter(pokemonList) { pokemon ->
            println(pokemon.latitud)
            println(pokemon.longitud)
            abrirGoogleMaps(pokemon.latitud, pokemon.longitud)
        }
        recyclerView.adapter = adapter
    }



    fun loadJSONFromAsset(context: Context, fileName: String): String? {
        val json: String?
        try {
            val inputStream = context.assets.open(fileName)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, Charset.forName("UTF-8"))
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }

    fun abrirGoogleMaps(latitud: Double, longitud: Double) {
        Log.d("MapsIntentUri", "Opening URI: $longitud")

        val gmmIntentUri = Uri.parse("geo:$latitud,$longitud?q=$latitud,$longitud")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        if (mapIntent.resolveActivity(packageManager) != null) {
            startActivity(mapIntent)
        } else {
            Toast.makeText(this, "Google Maps no está instalado.", Toast.LENGTH_SHORT).show()
        }
    }

}
