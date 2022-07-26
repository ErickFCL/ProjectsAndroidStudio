package com.example.exam_t3_2.Services;

import com.example.exam_t3_2.Entities.Contact;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IContactService {
    @GET("contacts")
    Call<List<Contact>> getContacts();

    // contacts/:id
    @GET("contacts/{id}")
    Call<Contact> findContact(@Path("id") int id);

    @POST("contacts")
    Call<Contact> create(@Body Contact contact);

    @PUT("contacts/{id}")
    Call<Contact> update(@Path("id") int id, @Body Contact contact);

    @DELETE("contacts/{id}")
    Call<Contact> delete(@Path("id") int id);
}
