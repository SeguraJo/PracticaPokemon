package com.example.practicapokemon.database.modelo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon")
data class Pokemon (
    @PrimaryKey val id:Int,
    val nombre: String,
    val altura: String,
    val peso: Int,
    val latitud:Int,
    val habilidades: String,
    val imagen: String,
)