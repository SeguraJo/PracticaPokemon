package com.example.practicapokemon.database.modelo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PokemonViewModelFactory(private val pokemonDao:PokemonDao):ViewModelProvider.Factory {
    override fun<T:ViewModel> create(modelClass:Class<T>):T{
        if ( modelClass.isAssignableFrom(PokemonViewModel::class.java) ){
            @Suppress("UNCHEKED_CAST")
            return PokemonViewModel(pokemonDao) as T
        }
        throw IllegalArgumentException("Clase de ViewModel desconocida")
    }
}