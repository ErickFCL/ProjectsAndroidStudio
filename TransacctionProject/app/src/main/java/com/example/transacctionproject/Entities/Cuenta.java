package com.example.transacctionproject.Entities;

public class Cuenta {
    public int Id;
    public String Nombre;
    public String Tipo;
    public int Monto;

    public Cuenta() {
    }

    public Cuenta(int id, String nombre, String tipo, int monto) {
        Id = id;
        Nombre = nombre;
        Tipo = tipo;
        Monto = monto;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public int getMonto() {
        return Monto;
    }

    public void setMonto(int monto) {
        Monto = monto;
    }
}
