package com.example.exament3_maps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.exament3_maps.Entities.Tienda;
import com.example.exament3_maps.Factories.RetrofitFactory;
import com.example.exament3_maps.Services.TiendaService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RegistrarActivity extends AppCompatActivity{
    //Contacto contacts = new Contacto();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);



        Button btnRegistrar = findViewById(R.id.btnRegistrar);
        EditText Titulo = findViewById(R.id.txtTitulo);
        EditText Resumen = findViewById(R.id.txtResumen);
        EditText Autor = findViewById(R.id.txtAutor);
        EditText FechaPublicacion = findViewById(R.id.textFechaP);
        EditText Tienda1 = findViewById(R.id.textTienda1);
        EditText Tienda2 = findViewById(R.id.textTienda2);
        EditText Tienda3 = findViewById(R.id.textTienda3);
        ImageView Imagen = findViewById(R.id.idImg);



        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //int numero = Integer.parseInt(Numero.getText().toString());
                //double latitude = Double.parseDouble(Latitude.getText().toString());
                //double longitude = Double.parseDouble(Longitude.getText().toString());
                String titulo = Titulo.getText().toString();
                String resumen = Resumen.getText().toString();
                String autor = Autor.getText().toString();
                String fechaPublicacion = FechaPublicacion.getText().toString();
                String tienda1 = Tienda1.getText().toString();
                String tienda2 = Tienda2.getText().toString();
                String tienda3 = Tienda3.getText().toString();
                ImageView imagen = findViewById(R.id.idImg);

                Tienda tienda = new Tienda(6,titulo,resumen,autor,fechaPublicacion,tienda1,tienda2,tienda3,"vacio");

                Retrofit retrofit = RetrofitFactory.build();
                TiendaService service = retrofit.create(TiendaService.class);
                Call<Tienda> call = service.create(tienda);
                call.enqueue(new Callback<Tienda>() {
                    @Override
                    public void onResponse(Call<Tienda> call, Response<Tienda> response) {

                    }

                    @Override
                    public void onFailure(Call<Tienda> call, Throwable t) {

                    }
                });


                Intent intent = new Intent(RegistrarActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}