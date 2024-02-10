package com.example.practicapokemon.database.modelo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon")
data class Pokemon (
    @PrimaryKey val id:Int,
    val nombre: String,
    val tipo: String,
    val altura: String,
    val peso: String,
    val latitud: Double,
    val longitud: Double,
    val habilidades: String,
    val imagen: String,
)