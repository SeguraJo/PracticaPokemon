
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.practicapokemon.MapActivity
import com.example.practicapokemon.R
import com.example.practicapokemon.database.modelo.Pokemon

class PokemonRecyclerView : ListAdapter<Pokemon, PokemonRecyclerView.PokemonViewHolder>(PokemonDiffCallback()) {

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
        val pokemon = getItem(position)
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
        }
        }
    }

    private class PokemonDiffCallback : DiffUtil.ItemCallback<Pokemon>() {
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem == newItem
        }
    }

