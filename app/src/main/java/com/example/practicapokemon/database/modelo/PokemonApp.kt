package com.example.practicapokemon.database.modelo

import android.app.Application
import com.example.practicapokemon.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class PokemonApp:Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy { AppDatabase.getDataBase(this, applicationScope) }
    val repositorio by lazy {PokemonRepositorio(database.PokemonDao())}
}