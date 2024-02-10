package com.example.practicapokemon

import com.example.practicapokemon.database.modelo.Pokemon

interface OnItemClickListener {
    fun onItemClick(pokemon: Pokemon)
}