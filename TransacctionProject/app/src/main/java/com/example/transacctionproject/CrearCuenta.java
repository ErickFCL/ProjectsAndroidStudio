package com.example.transacctionproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.transacctionproject.Entities.Cuenta;
import com.example.transacctionproject.Factories.RetrofitFactory;
import com.example.transacctionproject.Service.CuentaService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CrearCuenta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);

        EditText Nombre = findViewById(R.id.edtNombreCuenta);
        EditText Tipo = findViewById(R.id.edtTipoCuenta);
        EditText Monto = findViewById(R.id.edtMontoCuenta);
        Button btnRegistrar = findViewById(R.id.btnRegistrar);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Retrofit retrofit = RetrofitFactory.build(getApplicationContext());
                CuentaService service = retrofit.create(CuentaService.class);

                Cuenta cuenta = new Cuenta();
                cuenta.Nombre = Nombre.getText().toString();
                cuenta.Tipo = Tipo.getText().toString();
                cuenta.Monto = Integer.parseInt(Monto.getText().toString());

                Call<Cuenta> callImage = service.create(cuenta);
                callImage.enqueue(new Callback<Cuenta>() {
                    @Override
                    public void onResponse(Call<Cuenta> call, Response<Cuenta> response) {

                    }

                    @Override
                    public void onFailure(Call<Cuenta> call, Throwable t) {

                    }
                });

            }
        });
    }
}