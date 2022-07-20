package com.example.exament3_maps.Services;

import com.example.exament3_maps.Entities.Tienda;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface TiendaService {
    @GET("contacts")
    retrofit2.Call<List<Tienda>> getContacts();

    // contacts/:id
    @GET("contacts/{id}")
    retrofit2.Call<Tienda> findContact(@Path("id") int id);

    @POST("contacts")
    retrofit2.Call<Tienda> create(@Body Tienda contact);

    @DELETE("contacts/{id}")
    retrofit2.Call<Tienda> delete(@Path("Id") int Id);
}
