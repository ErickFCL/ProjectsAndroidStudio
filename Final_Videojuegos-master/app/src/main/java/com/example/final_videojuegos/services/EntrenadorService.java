package com.example.final_videojuegos.services;

import com.example.final_videojuegos.entities.Entrenador;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface EntrenadorService {

    @GET("entrenador/N00031931")
    Call<Entrenador> getEntrenador();

    @POST("entrenador/N00031931")
    Call<Entrenador> postEntrenador(@Body Entrenador entrenador);

}
