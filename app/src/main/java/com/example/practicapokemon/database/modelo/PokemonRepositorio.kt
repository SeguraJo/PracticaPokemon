package com.example.practicapokemon.database.modelo

import androidx.annotation.WorkerThread
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.Flow

class PokemonRepositorio (private val pokemonDao: PokemonDao) : ViewModelProvider.Factory {

    val listaPokemon: Flow<List<Pokemon>> = pokemonDao.obtenerTodos()

    @WorkerThread
    suspend fun insert(pokemon: Pokemon){
        pokemonDao.insertar(pokemon)
    }



}