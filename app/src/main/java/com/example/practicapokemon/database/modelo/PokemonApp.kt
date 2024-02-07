package com.example.practicapokemon.database.modelo

import android.app.Application
import com.example.practicapokemon.AppDatabase

class PokemonApp:Application() {
    val database: AppDatabase by lazy { AppDatabase.getDataBase(this) }
}