package com.anncode.basedatos.view;

import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by anahisalgado on 23/07/16.
 */
public interface IListaContactosActivity {

    void setUpFAB();
    ArrayAdapter<String> createAdapter(ArrayList<String> nombresContacto);
    void setAdapterListView(ArrayAdapter<String> adapter);
}
