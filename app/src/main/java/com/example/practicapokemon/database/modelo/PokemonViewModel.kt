package com.example.practicapokemon.database.modelo

import androidx.lifecycle.ViewModel
import com.example.practicapokemon.database.modelo.Pokemon
import com.example.practicapokemon.database.modelo.PokemonDao

class PokemonViewModel(private val pokemonDao: PokemonDao): ViewModel() {
    fun obtenerListadoPokemon(): List<Pokemon> = pokemonDao.obtenerTodos()
    fun obtenerListadoParada(nombre:String):List<Pokemon> = pokemonDao.obtenerNombreParada(nombre)
}