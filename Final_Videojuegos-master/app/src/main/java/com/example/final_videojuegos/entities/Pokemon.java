package com.example.final_videojuegos.entities;

public class Pokemon {

    public String id;
    public String codigo;
    public String nombre;
    public String tipo;
    public String url_imagen;
    public String esta_atrapado;

    public Pokemon(String nombre, String tipo, String url_imagen) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.url_imagen = url_imagen;
    }

    public Pokemon(String id, String codigo, String nombre, String tipo, String url_imagen, String esta_atrapado) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.url_imagen = url_imagen;
        this.esta_atrapado = esta_atrapado;
    }

}
