package com.example.practicapokemon.database.modelo

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData

class PokemonViewModel(private val repositorio: PokemonRepositorio): ViewModel() {
    val listadoPokemon: LiveData<List<Pokemon>> = repositorio.listaPokemon.asLiveData()
}
class PokemonViewModelFactory(private val repositorio: PokemonRepositorio): ViewModelProvider.Factory {
    override fun<T:ViewModel> create(modelClass:Class<T>):T{
        if ( modelClass.isAssignableFrom(PokemonViewModel::class.java) ){
            @Suppress("UNCHEKED_CAST")
            return PokemonViewModel(repositorio) as T
        }
        throw IllegalArgumentException("Clase de ViewModel desconocida")
    }
}