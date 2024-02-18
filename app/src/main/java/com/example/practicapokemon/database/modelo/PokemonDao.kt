package com.example.practicapokemon.database.modelo

import androidx.room.Insert
import androidx.room.Query

interface PokemonDao {
    @Query("SELECT * FROM pokemon ORDER BY nombre asc")
    fun obtenerTodos(): List<Pokemon>

    @Insert
    fun insertar(pokemon: Pokemon)
}