package com.example.transacctionproject.Service;

import com.example.transacctionproject.Entities.Cuenta;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface CuentaService {
    @GET("Account")
    retrofit2.Call<List<Cuenta>> getCuentas();

    @POST("Account")
    retrofit2.Call<Cuenta> create(@Body Cuenta cuenta);

}
