package com.example.exament3_maps.Entities;

public class Tienda {
    public int Id;
    //public String Nombre;
    //public String Tipo;
    //public String Region;
    //public String Imagen;
    //public int Numero;
    //public double Latitude;
    //public double Longitude;
    public String Titulo;
    public String Resumen;
    public String Autor;
    public String FechaPublicacion;
    public String Tienda1;
    public String Tienda2;
    public String Tienda3;
    public String Imagen;

    public Tienda(int id, String titulo, String resumen, String autor, String fechaPublicacion, String tienda1, String tienda2, String tienda3, String imagen) {
        Id = id;
        Titulo = titulo;
        Resumen = resumen;
        Autor = autor;
        FechaPublicacion = fechaPublicacion;
        Tienda1 = tienda1;
        Tienda2 = tienda2;
        Tienda3 = tienda3;
        Imagen = imagen;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getResumen() {
        return Resumen;
    }

    public void setResumen(String resumen) {
        Resumen = resumen;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public String getFechaPublicacion() {
        return FechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        FechaPublicacion = fechaPublicacion;
    }

    public String getTienda1() {
        return Tienda1;
    }

    public void setTienda1(String tienda1) {
        Tienda1 = tienda1;
    }

    public String getTienda2() {
        return Tienda2;
    }

    public void setTienda2(String tienda2) {
        Tienda2 = tienda2;
    }

    public String getTienda3() {
        return Tienda3;
    }

    public void setTienda3(String tienda3) {
        Tienda3 = tienda3;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String imagen) {
        Imagen = imagen;
    }
}