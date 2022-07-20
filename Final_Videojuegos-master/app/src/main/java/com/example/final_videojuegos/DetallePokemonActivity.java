package com.example.final_videojuegos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetallePokemonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pokemon);

        String nombre = getIntent().getStringExtra("nombre");
        String tipo = getIntent().getStringExtra("tipo");
        String image = getIntent().getStringExtra("image");
        String codigo = getIntent().getStringExtra("codigo");
        String atrapado = getIntent().getStringExtra("atrapado");

        TextView tvNombre = findViewById(R.id.tvNombreDetail);
        TextView tvTipo = findViewById(R.id.tvTipoDetail);
        TextView tvCodigo = findViewById(R.id.tvCodigoDetail);
        TextView tvAtrapado = findViewById(R.id.tvAtrapadoDetail);
        ImageView ivPokemon = findViewById(R.id.imgPokemonDetail);

        tvNombre.setText(nombre);
        tvTipo.setText(tipo);
        tvCodigo.setText(codigo);
        tvAtrapado.setText(atrapado);
        Glide.with(getApplicationContext()).load(image).override(300,300).into(ivPokemon);

    }
}