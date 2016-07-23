package com.anncode.basedatos.model;

/**
 * Created by anahisalgado on 23/07/16.
 */
public class Contacto {

    private int id;
    private String nombre;
    private String email;
    private String twitter;

    public Contacto() {
    }

    public Contacto(int id, String nombre, String email, String twitter) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.twitter = twitter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }
}
