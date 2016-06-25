package com.anncode.fragments.model;

import java.io.Serializable;

/**
 * Created by anahisalgado on 18/06/16.
 */
public class Amigo implements Serializable{

    private String nombre;
    private String twitter;
    private String telefono;

    public Amigo() {
    }

    public Amigo(String nombre, String twitter, String telefono) {
        this.nombre = nombre;
        this.twitter = twitter;
        this.telefono = telefono;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
