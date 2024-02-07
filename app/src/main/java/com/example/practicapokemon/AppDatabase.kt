package com.example.practicapokemon.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.practicapokemon.database.modelo.Pokemon
import com.example.practicapokemon.database.modelo.PokemonDao

@Database(entities = [Pokemon::class], version = 1)
abstract class AppDatabase: RoomDatabase(){

    abstract fun PokemonDao(): PokemonDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        val instance: AppDatabase?
            get() = INSTANCE

        fun getDataBase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "PokemonDB"
                ).createFromAsset("database/Pokemon.db")
                    .build()
                INSTANCE = instance
// Devolver instancia de base de datos
                instance
            }
        }
    }

}


