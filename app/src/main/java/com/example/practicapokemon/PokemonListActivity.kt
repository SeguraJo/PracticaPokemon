package com.example.practicapokemon

import PokemonRecyclerView
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practicapokemon.database.modelo.PokemonApp
import com.example.practicapokemon.database.modelo.PokemonViewModel
import com.example.practicapokemon.database.modelo.PokemonViewModelFactory

class PokemonListActivity : AppCompatActivity() {

    private val viewModel: PokemonViewModel by viewModels {
        PokemonViewModelFactory((application as PokemonApp).repositorio)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_list)

        viewModel.listadoPokemon.observe(this, Observer { pokemon ->
            pokemon?.let {
                val recyclerView: RecyclerView = findViewById(R.id.pokemonRecyclerView)
                val adapter = PokemonRecyclerView()

                recyclerView.adapter = adapter
                recyclerView.layoutManager = LinearLayoutManager(this)

                adapter.submitList(it)
            }
        })
    }
}
