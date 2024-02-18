package com.example.practicapokemon

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.practicapokemon.database.modelo.Pokemon

class PokemonRecyclerView(private val pokemonList: List<Pokemon>, private val onItemClickListener: (Pokemon) -> Unit) : RecyclerView.Adapter<PokemonRecyclerView.PokemonViewHolder>() {

    class PokemonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.pokemonImageView)
        val nameTextView: TextView = view.findViewById(R.id.pokemonNameTextView)
        // Incluye otras vistas según sea necesario
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = pokemonList[position]
        holder.nameTextView.text = pokemon.nombre
        // Carga la imagen desde la URL con Glide
        Glide.with(holder.imageView.context)
            .load(pokemon.imagen)
            .into(holder.imageView)

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, MapActivity::class.java).apply {
                putExtra("latitud", pokemon.latitud)
                putExtra("longitud", pokemon.longitud)
            }
            context.startActivity(intent)
            onItemClickListener(pokemon)
        }
    }



    override fun getItemCount(): Int = pokemonList.size
}
