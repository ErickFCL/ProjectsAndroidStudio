package com.example.final_videojuegos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.final_videojuegos.adapters.PokemonAdapter;
import com.example.final_videojuegos.entities.Pokemon;
import com.example.final_videojuegos.services.PokemonService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokemonListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_list);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://upn.lumenes.tk/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PokemonService service = retrofit.create(PokemonService.class);
        Call<List<Pokemon>> pokemons = service.getPokemons();

        pokemons.enqueue(new Callback<List<Pokemon>>() {
            @Override
            public void onResponse(Call<List<Pokemon>> call, Response<List<Pokemon>> response) {
                List<Pokemon> p = response.body();
                RecyclerView rv = findViewById(R.id.rvPokemons);
                rv.setLayoutManager(new LinearLayoutManager(PokemonListActivity.this));
                PokemonAdapter adapter = new PokemonAdapter(p);
                rv.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Pokemon>> call, Throwable t) {

            }
        });

        FloatingActionButton btnHome = findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PokemonListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}