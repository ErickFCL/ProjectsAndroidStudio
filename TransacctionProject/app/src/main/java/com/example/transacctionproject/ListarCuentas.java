package com.example.transacctionproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.transacctionproject.Adapter.AccountAdapter;
import com.example.transacctionproject.Entities.Cuenta;
import com.example.transacctionproject.Factories.RetrofitFactory;
import com.example.transacctionproject.Service.CuentaService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ListarCuentas extends AppCompatActivity {
    List<Cuenta> cuentitas = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_cuentas);

        Retrofit retrofit = RetrofitFactory.build(this);
        CuentaService service = retrofit.create(CuentaService.class);
        Call<List<Cuenta>> call = service.getCuentas();
        call.enqueue(new Callback<List<Cuenta>>() {
            @Override
            public void onResponse(Call<List<Cuenta>> call, Response<List<Cuenta>> response) {
                if(!response.isSuccessful()) {
                    Log.e("APP_VJ20202", "Error de aplicación");
                } else {
                    Log.i("APP_VJ20202", "Respuesta Correcta");
                    cuentitas = response.body();
                    AccountAdapter adapter = new AccountAdapter(cuentitas);

                    RecyclerView rv = findViewById(R.id.rvCuentas);
                    rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    rv.setHasFixedSize(true);
                    rv.setAdapter(adapter);
                    Log.i("rbv","llegaxxx: ");
                }
            }

            @Override
            public void onFailure(Call<List<Cuenta>> call, Throwable t) {
                Log.e("APP_VJ20202", "No hubo conectividad con el servicio web");
            }
        });
    }
}