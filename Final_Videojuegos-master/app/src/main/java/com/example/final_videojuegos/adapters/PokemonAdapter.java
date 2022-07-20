package com.example.final_videojuegos.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.example.final_videojuegos.DetallePokemonActivity;
import com.example.final_videojuegos.R;
import com.example.final_videojuegos.entities.Pokemon;

import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {

    List<Pokemon> pokemons;

    public PokemonAdapter(List<Pokemon> pokemons) {this.pokemons = pokemons;}

    @Override
    public PokemonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false);
        return new PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PokemonAdapter.PokemonViewHolder holder, int position) {
        View view = holder.itemView;
        Pokemon pokemon = pokemons.get(position);

        ImageView ivPokemon = view.findViewById(R.id.imgPokemon);
        TextView tvNombrePokemon = view.findViewById(R.id.tvNombrePokemon);
        TextView tvTipoPokemon = view.findViewById(R.id.tvTipoPokemon);

        Glide.with(view).asBitmap().load(pokemon.url_imagen).override(200,200).transform(new CircleCrop()).into(ivPokemon);
        tvNombrePokemon.setText(pokemon.nombre);
        tvTipoPokemon.setText(pokemon.tipo);

        Button btnDetailPokemon = view.findViewById(R.id.btnVerDetalle);

        btnDetailPokemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), DetallePokemonActivity.class);
                intent.putExtra("nombre", pokemon.nombre);
                intent.putExtra("tipo", pokemon.tipo);
                intent.putExtra("image", pokemon.url_imagen);
                intent.putExtra("codigo", pokemon.codigo);
                intent.putExtra("atrapado", pokemon.esta_atrapado);
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }

    public static class PokemonViewHolder extends RecyclerView.ViewHolder {public PokemonViewHolder(View itemView) {super(itemView);}}

}
