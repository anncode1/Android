package com.anncode.micardview;

/**
 * Created by anahisalgado on 26/03/16.
 */
public class Paisaje {

    private int foto;
    private String nombre;

    public Paisaje(int foto, String nombre) {
        this.foto = foto;
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
