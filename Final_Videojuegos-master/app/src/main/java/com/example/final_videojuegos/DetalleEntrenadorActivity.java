package com.example.final_videojuegos;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.final_videojuegos.entities.Entrenador;
import com.example.final_videojuegos.services.EntrenadorService;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetalleEntrenadorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_entrenador);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://upn.lumenes.tk/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EntrenadorService service = retrofit.create(EntrenadorService.class);

        TextView tvNombres = findViewById(R.id.tvNombresEntrenadorDetalle);
        TextView tvPueblo = findViewById(R.id.tvPuebloEntrenadorDetalle);
        ImageView imgEntrenador = findViewById(R.id.imgEntrenadorDetalle);

        Entrenador entrenador = new Entrenador();
        Call<Entrenador> entrenadorCall = service.getEntrenador();
        entrenadorCall.enqueue(new Callback<Entrenador>() {
            @Override
            public void onResponse(Call<Entrenador> call, Response<Entrenador> response) {
                tvNombres.setText(entrenador.nombres);
                tvPueblo.setText(entrenador.pueblo);
                byte[] bytes = Base64.decode(entrenador.imagen, Base64.DEFAULT);
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                imgEntrenador.setImageBitmap(bitmap);
            }

            @Override
            public void onFailure(Call<Entrenador> call, Throwable t) {

            }
        });

        /*if(getIntent().hasExtra("nombres")&&getIntent().hasExtra("pueblo")&&getIntent().hasExtra("imagen"))
        {
            String nombres = getIntent().getStringExtra("nombres");
            String pueblo = getIntent().getStringExtra("pueblo");
            String imagen = getIntent().getStringExtra("imagen");

            TextView tvNombres = findViewById(R.id.tvNombresEntrenadorDetalle);
            TextView tvPueblo = findViewById(R.id.tvPuebloEntrenadorDetalle);
            ImageView imgEntrenador = findViewById(R.id.imgEntrenadorDetalle);

            tvNombres.setText(nombres);
            tvPueblo.setText(pueblo);
            byte[] bytes = Base64.decode(imagen, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            imgEntrenador.setImageBitmap(bitmap);

        }*/

    }
}