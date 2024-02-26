package com.example.practicapokemon

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.practicapokemon.database.modelo.Pokemon
import com.example.practicapokemon.database.modelo.PokemonDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Pokemon::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun PokemonDao(): PokemonDao


    private class PokemonDataBaseCallBack(
        private val scope: CoroutineScope
    ) : Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database -> scope.launch {
                    val pokemonDao = database.PokemonDao()


// Crear objeto Pikachu
                    val pikachu = Pokemon(
                        1,
                        "Pikachu",
                        "Eléctrico",
                        "0.4 m",
                        "6.0 kg",
                        38.0536550,
                        -0.8690485,
                        "Electricidad Estática, Pararrayos",
                        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/25.png"
                    )

                    pokemonDao.insertar(pikachu)


// Crear objeto Charizard
                    val charizard = Pokemon(
                        2,
                        "Charizard",
                        "Fuego",
                        "1.7 m",
                        "90.5 kg",
                        38.0534285,
                        -0.8688959,
                        "Mar Llamas, Poder Solar",
                        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/6.png"
                    )

                    pokemonDao.insertar(charizard)

// Crear objeto Bulbasaur
                    val bulbasaur = Pokemon(
                        3,
                        "Bulbasaur",
                        "Planta",
                        "0.7 m",
                        "6.9 kg",
                        38.0538482,
                        0.8693184,
                        "Espesura, Clorofila",
                        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png"
                    )

                    pokemonDao.insertar(bulbasaur)

// Crear objeto Squirtle
                    val squirtle = Pokemon(
                        4,
                        "Squirtle",
                        "Agua",
                        "0.5 m",
                        "9.0 kg",
                        38.0530082,
                        -0.8690411,
                        "Torrente, Caparazón",
                        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/7.png"
                    )

                    pokemonDao.insertar(squirtle)


// Crear objeto Mewtwo
                    val mewtwo = Pokemon(
                        5,
                        "Mewtwo",
                        "Psíquico",
                        "2.0 m",
                        "122.0 kg",
                        38.0536447,
                        -0.8693422,
                        "Presión, Espejomágico",
                        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/150.png"
                    )
                    pokemonDao.insertar(mewtwo)

                }
            }
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        val instance: AppDatabase?
            get() = INSTANCE

        fun getDataBase(context: Context, scope:CoroutineScope): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "PokemonDB"
                ).addCallback(PokemonDataBaseCallBack(scope)).build()
                INSTANCE = instance
// Devolver instancia de base de datos
                instance
            }
        }
    }

}


