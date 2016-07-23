package com.anncode.basedatos.interactor;

import android.content.Context;

import com.anncode.basedatos.db.DataBaseAdapter;
import com.anncode.basedatos.model.Contacto;

import java.util.ArrayList;

/**
 * Created by anahisalgado on 23/07/16.
 */
public class ListaContactosActivityInteractorDB {
    Context context;
    DataBaseAdapter dataBaseAdapter;
    public ListaContactosActivityInteractorDB(Context context) {
        this.context = context;
        dataBaseAdapter = new DataBaseAdapter(context);
    }

    public ArrayList<String> getNombresContacto(){
        //Traer nombres contacto BD
        ArrayList<String> nombresContacto = new ArrayList<>();
        ArrayList<Contacto> contactos =
                dataBaseAdapter.getAllContacts();

        for (Contacto c:contactos) {
            nombresContacto.add(c.getNombre());
        }

        return nombresContacto;
    }

    public void insertContact(){

    }
}
