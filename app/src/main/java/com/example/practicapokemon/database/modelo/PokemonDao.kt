package com.example.practicapokemon.database.modelo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {
    @Query("SELECT * FROM pokemon")
    fun obtenerTodos(): Flow<List<Pokemon>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertar(pokemon:Pokemon)

    @Query("DELETE FROM pokemon")
    suspend fun eliminarTodos()


}